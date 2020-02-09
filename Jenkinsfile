pipeline {
  agent any
  stages {
    stage('Build Assets') {
      steps {
        echo 'Start Build Step'
        dir(path: 'gtas-parent') {
          sh 'mvn clean install -Dlicense.skip=true -Dskip.unit.tests=true'
        }

        echo 'Build Step Complete'
      }
    }

    stage('Print build number') {
      parallel {
        stage('Print build number') {
          steps {
            echo "This is build number ${BUILD_ID}"
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