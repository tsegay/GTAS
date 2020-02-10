pipeline {
  agent any
  stages {
    stage('Build and Sonar Qube analysis') {
      steps {
        echo 'Start Build Step'
        dir(path: 'gtas-parent') {
          sh 'mvn clean package sonar:sonar -Dlicense.skip=true -Dskip.unit.tests=true'
        }

        echo 'Build Step Complete'
      }
    }

    stage('Print build number') {
      parallel {
        stage('Print build number') {
          steps {
            echo "Build Number ${BUILD_ID}"
          }
        }

        stage('Test') {
          steps {
            echo 'Test Step'
          }
        }

      }
    }

  }
}
