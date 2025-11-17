// Load stage scripts
def buildStage = load "${env.WORKSPACE}/.pipeline/stages/build.groovy"
def testStage = load "${env.WORKSPACE}/.pipeline/stages/test.groovy"
def deployStage = load "${env.WORKSPACE}/.pipeline/stages/deploy.groovy"

node {
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

