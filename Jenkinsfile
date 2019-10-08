pipeline {
    agent none

    stages {
        stage('Build'){
            agent {
                docker 'maven:3.6.2-jdk-11'
            }
        }
    }

}
