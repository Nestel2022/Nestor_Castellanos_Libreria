// Importa la librería compartida registrada en Jenkins
@Library('obsschool-sharedlib') _

pipeline {
    agent any   // Se puede usar cualquier agente

    stages {
        stage('Build') {
            steps {
                echo 'Compilando proyecto...'
            }
        }

        stage('Static Analysis') {
            steps {
                // Llamada a la función de la librería
                // abortPipeline: false → el pipeline continúa
                staticAnalysis(abortPipeline: false)
            }
        }

        stage('Deploy') {
            steps {
                echo 'Desplegando aplicación...'
            }
        }
    }
}
