def call(Map params = [:]) {
    // Parámetro para decidir si abortar siempre
    def abortPipeline = params.get('abortPipeline', false)

    // Ejecutar análisis con SonarQube
    timeout(time: 5, unit: 'MINUTES') {
        withSonarQubeEnv('SonarQubeServer') {
            // Ajusta las propiedades según tu proyecto real
            sh '''
                sonar-scanner \
                -Dsonar.projectKey=mi-proyecto \
                -Dsonar.projectName="Proyecto Demo" \
                -Dsonar.sources=src \
                -Dsonar.login=$SONAR_AUTH_TOKEN
            '''
        }
    }

    // Esperar resultados del Quality Gate con timeout
    timeout(time: 5, unit: 'MINUTES') {
        def qg = waitForQualityGate()
        if (abortPipeline || qg.status != 'OK') {
            error("Pipeline abortado: QualityGate = ${qg.status}")
        } else {
            echo "Pipeline continúa: QualityGate = ${qg.status}"
        }
    }
}
