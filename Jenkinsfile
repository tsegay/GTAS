pipeline {
  agent any
  tools {
    maven 'maven 3.6.3'
    jdk 'jdk8'
  }
  stages {
    stage('Build and Sonar Qube analysis') {
      steps {
        echo 'Start Build Step'
        dir(path: 'gtas-parent') {
          withSonarQubeEnv('SonarQube') {
            sh 'mvn clean package sonar:sonar -Dlicense.skip=true'
          }
        }
        echo 'Build Step Complete'
      }
    }

    stage('Print build number') {
      parallel {
        stage('Print build number') {
          steps {
            echo "Build Number: ${BUILD_ID}"
          }
        }

      }
    }

  }
}
