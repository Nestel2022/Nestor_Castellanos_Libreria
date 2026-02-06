def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        withEnv(["SONAR_ENV=default"]) {
            sh 'echo "Ejecución de las pruebas de calidad de código"'
        }
    }

    if (abortPipeline) {
        error("Pipeline abortado por configuración de staticAnalysis")
    } else {
        echo "Pipeline continúa después del análisis estático"
    }
}
