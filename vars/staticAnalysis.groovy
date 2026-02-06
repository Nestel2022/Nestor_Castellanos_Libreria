def call(Map params = [:]) {
    def abortPipeline = params.get('abortPipeline', false)

    timeout(time: 5, unit: 'MINUTES') {
        // Usamos el plugin de SonarQube
        withSonarQubeEnv('SonarQubeServer') {
            sh 'sonar-scanner'
        }
    }

    // Esperar resultados del Quality Gate
    def qg = waitForQualityGate()
    if (abortPipeline || qg.status != 'OK') {
        error("Pipeline abortado: QualityGate = ${qg.status}")
    } else {
        echo "Pipeline continúa: QualityGate = ${qg.status}"
    }
}
