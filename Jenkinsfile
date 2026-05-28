pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './mvnw -B clean compile'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw -B test'
            }
        }
    }

    post {
        always {
            echo "[*] Archiving test results..."
            junit 'target/surefire-reports/**/*.xml'
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
        }

        failure {
            echo "Build or test failed!"
        }

        success {
            echo "Build and test succeeded!"
        }
    }
}
