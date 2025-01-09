node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'sonar';
    withSonarQubeEnv() {
      bat "\"${mvn}\\bin\\mvn\" clean verify sonar:sonar -Dsonar.projectKey=micros -Dsonar.projectName=\"micros\""
    }
  }
}
