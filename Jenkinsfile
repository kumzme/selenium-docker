pipeline {
2     agent any
3     stages {
4         stage('Build Jar') {
5             steps {
6                 bat "mvn clean package -DskipTests"
7             }
8         }
9         stage('Build Image') {
10             steps {
11                 bat "docker build -t='learndocker01/selenium-docker' ."
12             }
13         }
14         stage('Push Image') {
15             steps {
16 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
17 			        bat "docker login --username=${user} --password=${pass}"
18 			        bat "docker push learndocker01/selenium-docker:latest"
19 			    }                           
20             }
21         }
22     }
23 }