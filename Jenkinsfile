@Library('obsschool-sharedlib') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compilando proyecto...'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                staticAnalysis(abortPipeline: false)
            }
        }
    }
}
