pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6' // Must match the name in Jenkins Global Tool Configuration
        jdk 'Java_17'       // Must match the name in Jenkins Global Tool Configuration
    }

    environment {
        APP_NAME = "backend-app"
        JAR_FILE = "target/*.jar"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Gnanasai1234/BackendApp.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: "${JAR_FILE}", fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Backend build completed successfully!"
        }
        failure {
            echo "❌ Backend build failed. Please check the logs."
        }
    }
}
