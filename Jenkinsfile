node {
     {
         checkout scm
     }
        stage('Build') {
           sh 'mvn install'
        }
        stage('audit_service') {
            sh 'docker build -f Dockerfile'
            }
}




