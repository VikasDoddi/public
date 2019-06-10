node {
     {
         checkout scm
     }
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('audit_service') {
            sh cd /var/lib/jenkins/workspace/vikas-cicd/target/
            sh 'docker build -d audit-service -p 8080:8080 -f /var/lib/jenkins/workspace/vikas-cicd/Dockerfile'
            }
}




