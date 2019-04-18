pipeline {
  agent any
    stages {
      stage('Build Jar') {
          steps {
              bat "mvn clean package -DskipTests"
            }
        }
       stage('Build Image') {
         steps {
             bat "docker build -t learndocker01/selenium-docker ."
          }
       }
      stage('Push Image') {
         steps {
 	         withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
 		       bat "docker login --username=${user} --password=${pass}"
 		       bat "docker push learndocker01/selenium-docker:latest"
 		    }                           
      }
   }
  }
 }

