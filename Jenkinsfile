node {
  stage('Check JAVA_HOME') {
    bat 'echo %JAVA_HOME%'
  }

  stage('SCM') {
    checkout scm
  }

  stage('SonarQube Analysis - Back') {
    def mvn = tool 'sonar';
    withSonarQubeEnv() {
      dir('back') {
        bat "\"${mvn}\\bin\\mvn\" clean verify sonar:sonar -Dsonar.projectKey=micros-back -Dsonar.projectName=\"micros-back\" -Dsonar.token=%SONAR_TOKEN_BACK%"
      }
    }
  }

  stage('SonarQube Analysis - Front') {
    def mvn = tool 'sonar';
    withSonarQubeEnv() {
      dir('front') {
        bat "\"${mvn}\\bin\\mvn\" clean verify sonar:sonar -Dsonar.projectKey=micros-front -Dsonar.projectName=\"micros-front\" -Dsonar.token=%SONAR_TOKEN_FRONT%"
      }
    }
  }
}

