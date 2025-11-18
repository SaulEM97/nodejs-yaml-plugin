node {
    stage('Checkout') {
        deleteDir()
        sh 'git clone https://github.com/SaulEM97/nodejs-yaml-plugin.git .'
    }

    stage('Load stages') {
        def buildStage  = load ".pipeline/stages/build.groovy"
        def testStage   = load ".pipeline/stages/test.groovy"
        def deployStage = load ".pipeline/stages/deploy.groovy"

        // expose them to later stages
        this.buildStage  = buildStage
        this.testStage   = testStage
        this.deployStage = deployStage
    }

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

