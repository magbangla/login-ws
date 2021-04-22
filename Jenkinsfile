pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'apt-get install -y maven'
        git(url: 'https://github.com/magbangla/login-ws.git', branch: 'master', credentialsId: 'github-user')
        sh 'echo "pipeline starting"'
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
        sh 'mvn package'
      }
    }

  }
}