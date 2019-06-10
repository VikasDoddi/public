node {
         checkout scm
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('audit_service') {
            sh 'docker build -t idexcel-interns/vikas-audit_service:${BUILD_NUMBER}  -f Dockerfile .'
            sh 'docker tag idexcel-interns/vikas-audit_service:${BUILD_NUMBER} idexcelinterns/vikas-audit_service:latest' 
            }
        stage('Push Image') { 
                sh 'docker login -u idexcelinterns -p kutty170065' 
                sh 'docker push idexcelinterns/vikas-audit_service:latest' 
        } 
        stage('Force Deploy') { 
                sh 'aws ecs update-service --region us-east-1 --cluster Vikas-ecs-cluster --service service_audit --force-new-deployment' 
        } 
  }