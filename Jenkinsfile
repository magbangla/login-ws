pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/magbangla/login-ws.git', branch: 'master', credentialsId: 'github-user')
        sh 'echo "pipeline starting"'
        sh 'mvn clean compile'
        sh 'apt-get install -y maven'
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