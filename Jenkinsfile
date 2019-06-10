node {
        stage('SCM Checkout') {
            
            git 'https://github.com/VikasDoddi/public.git'
        }
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('audit_service') {
            def Docker = tool name: '', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
            sh label: '', script: 'docker build -t audit_service:v1 -f Dockerfile .'        
            }
}
