def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        withEnv(["SONAR_ENV=default"]) {
            // Simulación del análisis de código
            sh 'echo "Ejecución de las pruebas de calidad de código"'
        }
    }

    // Evaluación del parámetro
    if (abortPipeline) {
        error("Pipeline abortado por configuración de staticAnalysis")
    } else {
        echo "Pipeline continúa después del análisis estático"
    }
}