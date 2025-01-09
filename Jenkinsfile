node {
  stage('Check JAVA_HOME') {
    bat 'echo %JAVA_HOME%'
  }
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'sonar';
    withSonarQubeEnv() {
      dir(back) {
        bat "\"${mvn}\\bin\\mvn\" clean verify sonar:sonar -Dsonar.projectKey=micros -Dsonar.projectName=\"micros\""
      }
    }
  }
}
