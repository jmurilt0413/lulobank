pipeline {
  agent any
  stages {
    stage("build"){
      git url: 'https://github.com/jmurilt0413/lulobank.git'
    withMaven {
      sh "mvn clean verify"
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
  




