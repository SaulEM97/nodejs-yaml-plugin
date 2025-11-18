def buildStage() {
    sh """
        echo "Cleaning old dependencies..."
        rm -rf node_modules package-lock.json

        echo "Running npm install..."
        npm install
    """
}

return this

