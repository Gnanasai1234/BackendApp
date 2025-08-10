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
                git branch: 'main', url: 'https://github.com/Gnanasai1234/BackendApp.git'
            }
        }

        stage('Build') {
            steps {
                echo "Using Backend URL: ${BACKEND_URL}"
                sh """
                export BACKEND_URL=${BACKEND_URL}
                ./gradlew build
                """
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application with backend URL: ${BACKEND_URL}"
                // deployment steps here
            }
        }
    }
}
