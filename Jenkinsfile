pipeline {
    agent any

    parameters {
        string(name: 'BACKEND_URL', defaultValue: 'http://localhost:8080', description: 'Backend API URL')
    }

    environment {
        BACKEND_URL = "${params.BACKEND_URL}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Gnanasai1234/BackendApp.git'
            }
        }

        stage('Build') {
            steps {
                echo "Using Backend URL: ${BACKEND_URL}"
                sh "./mvnw clean package -DskipTests"
            }
        }

        stage('Test') {
            steps {
                sh "./mvnw test"
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application with backend URL: ${BACKEND_URL}"
                // Example: java -jar target/*.jar &
            }
        }
    }
}
