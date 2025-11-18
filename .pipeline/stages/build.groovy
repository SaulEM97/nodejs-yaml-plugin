def buildStage() {
    sh """
        rm -rf node_modules
        npm install
    """
}
return this

