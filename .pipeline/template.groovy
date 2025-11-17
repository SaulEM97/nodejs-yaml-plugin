node {
    // Load stage scripts inside node
    def buildStage = load "${env.WORKSPACE}/.pipeline/stages/build.groovy"
    def testStage = load "${env.WORKSPACE}/.pipeline/stages/test.groovy"
    def deployStage = load "${env.WORKSPACE}/.pipeline/stages/deploy.groovy"

    stage('Build') {
        buildStage.buildStage()
    }

    stage('Test') {
        testStage.testStage()
    }

    stage('Deploy') {
        deployStage.deployStage()
    }
}

