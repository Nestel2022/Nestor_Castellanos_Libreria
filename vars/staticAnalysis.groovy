def call(Map params = [:]) {
    def abortPipeline = params.get('abortPipeline', false)

    timeout(time: 5, unit: 'MINUTES') {
        withSonarQubeEnv('SonarQubeServer') {
            sh '''
                sonar-scanner \
                -Dsonar.projectKey=mi-proyecto \
                -Dsonar.projectName="Proyecto Demo" \
                -Dsonar.sources=src \
                -Dsonar.login=$SONAR_AUTH_TOKEN
            '''
        }
    }

    def qg = waitForQualityGate()
    if (abortPipeline || qg.status != 'OK') {
        error("Pipeline abortado: QualityGate = ${qg.status}")
    } else {
        echo "Pipeline continúa: QualityGate = ${qg.status}"
    }
}
