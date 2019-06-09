node {
        stage('SCM Checkout') {
            
            git 'https://github.com/VikasDoddi/public.git'
        }
        stage('Build') {
           def M2_Home = tool name: 'maven_3_6_0', type: 'maven'
           sh "${M2_Home}/bin/mvn install"
        }
        stage('Building image') {
            def Docker = tool name: '', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
            def audit-image = docker.build("audit-image", "./Dockefile") 
        }
}
