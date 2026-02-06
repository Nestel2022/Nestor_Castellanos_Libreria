def call(Map params = [:]) {
    def abortPipeline = params.get('abortPipeline', false)
    def branchName = env.BRANCH_NAME ?: "unknown"

    timeout(time: 5, unit: 'MINUTES') {
        withEnv(["SONAR_ENV=default"]) {
            sh 'echo "Ejecución de las pruebas de calidad de código"'
        }
    }

    // Heurística de corte
    if (abortPipeline) {
        error("Pipeline abortado: abortPipeline=true")
    } else if (branchName == "master") {
        error("Pipeline abortado: ejecución en rama master")
    } else if (branchName.startsWith("hotfix")) {
        error("Pipeline abortado: ejecución en rama hotfix")
    } else {
        echo "Pipeline continúa en rama ${branchName}"
    }
}

