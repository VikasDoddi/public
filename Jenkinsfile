node {
        stage('SCM Checkout') {
            
            git 'https://github.com/VikasDoddi/public.git'
        }
        stage('Build') {
           def M2_Home = tool name: 'maven-3', type: 'maven'
           sh "${M2_Home}/opt/apache-maven-3.6.1 install"
        }
}