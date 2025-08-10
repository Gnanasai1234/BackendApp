pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'   // Name from Jenkins Global Tool Config
        jdk 'Java_17'         // Name from Jenkins Global Tool Config
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

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
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
            echo "✅ Build completed successfully!"
        }
        failure {
            echo "❌ Build failed. Check logs."
        }
    }
}
