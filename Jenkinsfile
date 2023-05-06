// def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.8.6' 
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
        // IMAGE_NAME = 'my-dockerhub-username/my-image-name'

    } 
    stages {
        // stage ("init") {
        //     steps {
        //         script {
        //             gv = load "script.groovy"
        //         }
        //     }
        // }
       

    // 1/  *********Microservice : api-Gateway*********** 
        
        stage("build jar, build and push docker images for api-gateway "){
            steps {
                dir ('api-Gateway') {
               script {
                        echo 'building the application'
                         sh 'mvn package'
                         sh 'docker build -t hedisayadi/api-gateway:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/api-gateway:1.0'
       
                }
                }
            }
        }

    // 2/ *********Microservice : discovery-server*********** 

         stage("build jar, build and push docker images for discovery-server "){
            steps {
                dir ('discovery-server') {
               script {
                         echo 'building the application'
                         sh 'mvn package'
                         sh 'docker build -t hedisayadi/discovery-server:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/discovery-server:1.0'
       
                }
                }
            }
        }

    //  3/  *********Microservice : movie-catatalog-service*********** 

         stage("build jar, build and push docker images for movie-catatalog-service"){
            steps {
                dir ('movie-catatalog-service') {
               script {
                         echo 'building the application'
                         sh 'mvn package'
                         sh 'docker build -t hedisayadi/movie-catatalog-service:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/movie-catatalog-service:1.0'
       
                }
                }
            }
        }

    //  4/   *********Microservice : movie-info-service*********** 

         stage("build jar, build and push docker images for movie-info-service "){
            steps {
                dir ('movie-info-service') {
               script {
                         echo 'building the application'
                         sh 'mvn package -DskipTests'
                         sh 'docker build -t hedisayadi/movie-info-service:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/movie-info-service:1.0'
       
                }
                }
            }
        }

    // 5/  *********Microservice : ratings-data-service*********** 

         stage("build jar, build and push docker images for ratings-data-service "){
            steps {
                dir ('ratings-data-service') {
               script {
                         echo 'building the application'
                         sh 'mvn package -DskipTests'
                         sh 'docker build -t hedisayadi/ratings-data-service:1.0 .'
                         sh 'export DOCKER_CLIENT_TIMEOUT=120'
                         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         sh 'docker push hedisayadi/ratings-data-service:1.0'
       
                }
                }
            }
        }
        stage("test"){
            steps{
                echo 'testing the app ...'
            }
        }
        // stage("running-servers"){
            
        //     steps{
        //         sh 'docker compose -f run-servers.yaml up -d'
        //     }
        // }
    }
}