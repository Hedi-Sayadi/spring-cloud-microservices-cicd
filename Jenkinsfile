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
        stage ("build jar") {
            steps {
                script {
                    echo 'building the application'
                    sh 'mvn package'
                }
            }
        }
        stage("build docker image"){
            steps {
               script {
                         sh 'docker build -t hedisayadi/test_cicd:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/test_cicd:1.0'
       
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