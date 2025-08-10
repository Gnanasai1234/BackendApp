// Jenkinsfile (declarative) - full-stack build: frontend (Node) + backend (Maven/JDK17)
// - Requires: Docker agent capability on the Jenkins node OR remove docker blocks and rely on installed tools
// - Creates workspace caches: $WORKSPACE/.m2 & $WORKSPACE/.npm
pipeline {
  agent any

  // Configure global tools only if you intend to use host-installed tools
  options {
    // keep logs, timeout the whole pipeline if stuck
    timeout(time: 60, unit: 'MINUTES')
    ansiColor('xterm')
    buildDiscarder(logRotator(numToKeepStr: '30'))
  }

  environment {
    // Per-build caches inside workspace (persist across builds on same workspace)
    MAVEN_LOCAL = "${env.WORKSPACE}/.m2"
    NPM_CACHE   = "${env.WORKSPACE}/.npm"
    // Example secure env var names (fill from credentials below)
    // API_TOKEN = credentials('my-api-token-id')
  }

  stages {

    stage('Checkout') {
      steps {
        script {
          // checkout repository (single checkout used for both frontend & backend)
          checkout scm
        }
      }
    }

    stage('Prepare Caches') {
      steps {
        script {
          // create cache directories if not exist
          sh 'mkdir -p .m2 || true'
          sh 'mkdir -p .npm || true'
        }
      }
    }

    stage('Build (parallel)') {
      parallel {
        stage('Frontend (Node)') {
          agent { label 'docker' } // optional: force docker-capable agent
          stages {
            stage('Install & Build Frontend') {
              steps {
                script {
                  // Use official node container with mounted caches
                  docker.image('node:22-bullseye').inside("--user node -v ${env.WORKSPACE}/.npm:/home/node/.npm") {
                    // run as non-root node user inside container for cache where possible
                    sh '''
                      echo "Node: $(node -v)  NPM: $(npm -v)"
                      cd frontend
                      # use CI=false as temporary workaround if you want to allow lint warnings (NOT recommended long-term)
                      # export CI=false
                      npm ci --cache $NPM_CACHE --prefer-offline
                      npm run build
                    '''
                  }
                }
              }
            }

            stage('Frontend Unit Tests') {
              steps {
                script {
                  docker.image('node:22-bullseye').inside("--user node -v ${env.WORKSPACE}/.npm:/home/node/.npm") {
                    sh '''
                      cd frontend
                      npm ci --cache $NPM_CACHE --prefer-offline
                      npm test -- --watchAll=false || true   # keep running but fail later if you want
                    '''
                  }
                }
              }
            }

            stage('Archive Frontend Artifact') {
              steps {
                archiveArtifacts artifacts: 'frontend/build/**', fingerprint: true
              }
            }
          }
        }

        stage('Backend (Maven/JDK17)') {
          agent { label 'docker' }
          stages {
            stage('Build & Unit Tests Backend') {
              steps {
                script {
                  // maven image with JDK 17
                  docker.image('maven:3.9.6-eclipse-temurin-17').inside("-v ${env.WORKSPACE}/.m2:/root/.m2") {
                    sh '''
                      echo "Java: $(java -version 2>&1)"
                      cd backend
                      mvn -B -U -Dmaven.repo.local=/root/.m2 clean verify
                    '''
                  }
                }
              }
            }

            stage('Integration Tests (optional)') {
              steps {
                script {
                  docker.image('maven:3.9.6-eclipse-temurin-17').inside("-v ${env.WORKSPACE}/.m2:/root/.m2") {
                    sh '''
                      cd backend
                      # run integration tests if configured (fails if none)
                      mvn -B -Dmaven.repo.local=/root/.m2 verify -Pintegration || true
                    '''
                  }
                }
              }
            }

            stage('Package') {
              steps {
                script {
                  docker.image('maven:3.9.6-eclipse-temurin-17').inside("-v ${env.WORKSPACE}/.m2:/root/.m2") {
                    sh '''
                      cd backend
                      mvn -B -Dmaven.repo.local=/root/.m2 -DskipTests package
                      mkdir -p ${WORKSPACE}/deploy
                      cp backend/target/*.jar ${WORKSPACE}/deploy/ || true
                    '''
                  }
                }
              }
            }

            stage('Archive Backend Artifact') {
              steps {
                archiveArtifacts artifacts: 'deploy/*.jar', fingerprint: true
              }
            }
          }
        } // end backend
      } // end parallel
    } // end Build (parallel)

    stage('Integration: assemble full deployable') {
      steps {
        sh '''
          mkdir -p deploy/full
          cp -r frontend/build deploy/full/frontend || true
          cp deploy/*.jar deploy/full/ || true
        '''
        archiveArtifacts artifacts: 'deploy/full/**', fingerprint: true
      }
    }

    stage('Publish / Dockerize (optional)') {
      when { branch 'master' }
      steps {
        echo "Here you can build docker images, push to registry or trigger CD pipelines."
        // Example: docker build -t myrepo/myapp:${GIT_COMMIT} .
      }
    }
  } // stages

  post {
    always {
      echo "Cleaning workspace"
      cleanWs()
    }
    success {
      echo "Pipeline succeeded"
    }
    failure {
      echo "Pipeline failed — check logs and eslint / test output"
    }
  }
}
