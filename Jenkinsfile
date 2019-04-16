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
           	 bat "docker built -t="learndocker01.seleniumdocker" ."
            }
         }
        stage('Push Image') {
           steps {
             withCredentials([usernamePassword(credentials: 'Dockerhud', passwordVariable: 'pass', usernameVariable: 'user')]
	        //sh
   	          //bat "docker login --username=${user} --password=${pass}"
	          bat "docker push learndocker01/selenium-docker:latest"
		    }
         }
       }
    }

}