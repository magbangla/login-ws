pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvm clean compile'
        git(url: 'https://github.com/magbangla/login-ws.git', branch: 'master', credentialsId: 'github-user')
      }
    }

    stage('Unit Test') {
      steps {
        sh 'mvm test'
      }
    }

    stage('Publish') {
      steps {
        sh '''mvm package
archive \'target/*.jar\''''
      }
    }

  }
}