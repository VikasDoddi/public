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
  
        stage('Stack Action'){
            sh 'aws --region us-east-1 cloudformation ${Action}-stack --stack-name ${Stack} --cluster Vikas-ecs-cluster --service service_audit --force-new-deployment'
       }
     
        stage('Stack Status'){
            sh 'aws --region us-east-1 cloudformation wait stack-${Action}-complete --stack-name ${EnvironmentType}-${Stack}'
   }
}