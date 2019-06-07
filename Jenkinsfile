Pipeline {
/* This is a Jenkinfile for Audit Service application */
    agent none
    stages {
        stage('SCM Checkout') {
            
            git 'https://github.com/praveen9876/audit-service.git'
        }
        stage('Build') {
           def M2_Home = tool name: 'maven-3', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }

    }
}