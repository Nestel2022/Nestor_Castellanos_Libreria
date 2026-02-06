@Library('obsschool-sharedlib') _

pipeline {
    agent any

    environment {        
        BRANCH_NAME = "hotfix-123"
    }

    stages {
        stage('Build') {
            steps {
                echo "Compilando proyecto en rama ${env.BRANCH_NAME}..."
            }
        }

        stage('Static Analysis') {
            steps {
                // Llamada a la librería con parámetro
                staticAnalysis(abortPipeline: false)
            }
        }

        stage('Deploy') {
            steps {
                echo "Desplegando aplicación..."
            }
        }
    }
}