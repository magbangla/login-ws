pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git credentialsId: 'github-user', url: 'https://github.com/magbangla/login-ws.git'
        sh 'mvm clean compile'
      }
    }

  }
}
