node {
    stage('Checkout') {
        deleteDir()
        sh 'git clone https://github.com/SaulEM97/nodejs-yaml-plugin.git .'
    }

    stage('Load stages') {
        buildStage  = load ".pipeline/stages/build.groovy"
        testStage   = load ".pipeline/stages/test.groovy"
        deployStage = load ".pipeline/stages/deploy.groovy"
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

