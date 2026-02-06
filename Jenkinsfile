@Library('obsschool-sharedlib') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compilando proyecto...'
            }
        }

        stage('Static Analysis') {
            steps {
                // Ejemplo normal (continúa)
                //staticAnalysis(abortPipeline: false)

                // Ejemplo alternativo (aborta)
                 staticAnalysis(abortPipeline: true)
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando aplicación...'
            }
        }
    }
}
