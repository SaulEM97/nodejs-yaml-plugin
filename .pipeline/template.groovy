node {
    stage('Build') {
        buildStage()
    }
    stage('Test') {
        testStage()
    }
    stage('Deploy') {
        deployStage()
    }
}

