// JTE Pipeline Template

node {
    stage('Checkout') {
        // Fully wipe the workspace BEFORE checkout
        deleteDir()

        // Use native Jenkins Git checkout
        checkout([
            $class: 'GitSCM',
            branches: [[name: '*/main']],
            userRemoteConfigs: [[
                url: 'https://github.com/SaulEM97/nodejs-yaml-plugin.git'
            ]]
        ])
    }

    stage('Load stages') {
        // Always declare scripts with def
        def buildStage  = load ".pipeline/stages/build.groovy"
        def testStage   = load ".pipeline/stages/test.groovy"
        def deployStage = load ".pipeline/stages/deploy.groovy"

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
}

