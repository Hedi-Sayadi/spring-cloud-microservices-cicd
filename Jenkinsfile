pipeline {
    agent any
    tools {
        maven 'maven-3.8.6' 
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
            IMAGE_NAME = 'my-dockerhub-username/my-image-name'

    } 
    stages {
        stage ("build jar api-gateway") {
            steps {
                dir ('api-Gateway') {
                script {
                    echo 'building the application'
                    sh 'mvn package'
                }
                }
            }
        }
        stage("build and push docker images for api-gateway "){
            steps {
                dir ('api-Gateway') {
               script {
                         sh 'docker build -t hedisayadi/api-gateway:2.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/api-gateway:2.0'
       
                }
                }
            }
        }
        stage("test"){
            steps{
                echo 'testing the app ...'
            }
        }
        stage("deploy"){
            
            steps{
                echo 'deploying the app ...'
            }
        }
    }
}