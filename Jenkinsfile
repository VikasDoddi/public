node {
         checkout scm
        stage('Build') {
            steps {
            dir ('audit-service')
                sh 'mvn clean install'
        }
        }
        stage('audit_service') {
            steps {
            dir ('audit-service')
            sh 'docker build -f Dockerfile'
            }
        }
}




