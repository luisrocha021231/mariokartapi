pipeline {
    agent any

    environment {
        APP_NAME = 'mariokartapi'
        VERSION = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'SubversionSCM',
                    locations: [[credentialsId: '8a9a4618-cf6d-4869-90b1-d470ee737b66',
                                 remote: 'http://localhost:8081/scm/svn/scmadmin/mariokartapi/trunk']],
                    workspaceUpdater: [$class: 'UpdateUpdater']
                ])
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t ${APP_NAME}:${VERSION} .
                """
            }
        }

        stage('Deploy Container') {
            steps {
                sh """
                    docker rm -f ${APP_NAME} || true
                    docker run -d --name ${APP_NAME} -p 8082:8082 ${APP_NAME}:${VERSION}
                """
            }
        }
    }
}