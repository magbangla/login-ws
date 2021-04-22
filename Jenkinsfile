pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/magbangla/login-ws.git', branch: 'master', credentialsId: 'github-user')
        sh 'mvn clean compile'
      }
    }

    stage('Unit Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Publish') {
      steps {
        sh '''mvn package
archive \'target/*.jar\''''
      }
    }

  }
}
