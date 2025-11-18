def deployStage() {
    stage('Deploy') {
        sh """
            pm2 delete all || true
            pm2 start index.js --name app
        """

        // Confirmación
        sh "pm2 list"
        sh "sleep 2"
        sh "curl -v http://localhost:3000 || true"
    }
}

