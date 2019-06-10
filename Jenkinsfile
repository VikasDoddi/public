node {
         checkout scm
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('audit_service') {
            sh 'docker build -f Dockerfile .'
            }
        stage 'Docker push'
            docker.withRegistry('https://012515449968.dkr.ecr.us-east-1.amazonaws.com', '$(aws ecr get-login --no-include-email --region us-east-1)') {
            docker.image('audit_service').push('latest')
  }


}
