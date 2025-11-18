def buildStage() {
    sh """
        rm -rf node_modules
        npm ci
    """
}
return this

