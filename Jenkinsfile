node {
         checkout scm
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('audit_service') {
            sh 'docker build -f Dockerfile .'
            sh 'docker tag audit_service audit_service:latest' 
            }
         stage('Push Image') { 
                sh 'docker login -u idexcelinterns -p kutty170065' 
                sh 'docker push audit_service:latest' 
        } 
  }