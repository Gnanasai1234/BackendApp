pipeline {
    agent any

    tools {
        jdk 'jdk17'           // Adjust based on your JDK installation in Jenkins
        maven 'maven3'        // Adjust based on your Maven installation in Jenkins
    }

    environment {
        REPO_URL = 'https://github.com/Gnanasai1234/BackendApp.git'
        BRANCH = 'master'
        APP_NAME = 'BackendApp'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning ${env.APP_NAME} (${env.BRANCH} branch)..."
                git branch: env.BRANCH, url: env.REPO_URL
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling application...'
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh './mvnw test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                sh './mvnw package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                echo 'Archiving JAR artifact...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo "✅ ${env.APP_NAME} build succeeded on ${env.BRANCH}!"
        }
        failure {
            echo "❌ ${env.APP_NAME} build failed on ${env.BRANCH}. Check logs."
        }
    }
}
