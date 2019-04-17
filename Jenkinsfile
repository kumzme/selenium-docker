pipeline {
 // master executor should be set to 0
    //agent none - linux
    agent any
    stages {
        stage('Build Jar') {
          steps{
              //sh
            bat "mvn clean package -DskipTests"
          }
         }
         stage('Build Image') {
           steps {
           	bat "docker build  -t='learndocker01.seleniumdocker' ."
            }
         }
        stage('Push Image') {
           steps {
             withCredentials([usernamePassword(credentials: 'Dockerhub', passwordVariable: 'pass', usernameVariable: 'user')])
   	         bat " docker login --username=${user} --password=${pass} "
	         bat " docker push learndocker01/selenium-docker:latest "
		    }
         }
       }
    }