node {
    stage('Checkout') {
        // Remove workspace if needed
        deleteDir()  // Optional, ensures clean workspace

        // Clone the repo
        sh 'git clone https://github.com/SaulEM97/nodejs-yaml-plugin.git .'
    }

    stage('Load stages') {
        def buildStage = load ".pipeline/stages/build.groovy"
        def testStage = load ".pipeline/stages/test.groovy"
        def deployStage = load ".pipeline/stages/deploy.groovy"

        stage('Build') { buildStage.buildStage() }
        stage('Test') { testStage.testStage() }
        stage('Deploy') { deployStage.deployStage() }
    }
}

