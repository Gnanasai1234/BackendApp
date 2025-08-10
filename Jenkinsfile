pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6' // Must match your Jenkins Maven installation name
        jdk 'Java_17'       // Must match your Jenkins JDK installation name
    }

    environment {
        APP_NAME = "my-backend-app"
        JAR_FILE = "target/*.jar"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                echo "Deploying ${APP_NAME}..."
                // Example: Copy JAR to server
                // sh 'scp target/my-backend-app.jar user@server:/path/to/deploy'
            }
        }
    }

    post {
        success {
            echo "Build completed successfully!"
        }
        failure {
            echo "Build failed!"
        }
    }
}
