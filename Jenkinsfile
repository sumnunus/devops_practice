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
            sh '''
                echo "Build Result: SUCCESS" > build-result.txt
                echo "Job: ${JOB_NAME}" >> build-result.txt
                echo "Build Number: ${BUILD_NUMBER}" >> build-result.txt
                echo "Time: $(date)" >> build-result.txt
            '''
            archiveArtifacts artifacts: 'build-result.txt'
            mail to: 'lavesujin@gmail.com',
                 subject: "[Jenkins] ${JOB_NAME} #${BUILD_NUMBER} - SUCCESS",
                 body: "Build succeeded!\n\nJob: ${JOB_NAME}\nBuild: #${BUILD_NUMBER}\nURL: ${BUILD_URL}"
        }
    }
}
