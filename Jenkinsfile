pipeline {
  agent any
  stages {
    stage("build"){
      steps{
        echo 'building the app...'
        whitMaven(maven : 'apache-maven-3.8.2'){
            bat 'mvn clean install' 
        }
      }
    }
    stage("test"){
      steps{
        echo 'testing the app...'
      }
    }
    stage("deploy"){
      steps{
        echo 'deploying the app...'
      }
    }
  }
}
  




