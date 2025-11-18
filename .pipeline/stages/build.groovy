def buildStage() {

    sh """
        echo "==============================="
        echo " CLEANING WORKSPACE"
        echo "==============================="

        # Clean node_modules if any leftover cache exists
        rm -rf node_modules package-lock.json

        echo "==============================="
        echo " INSTALLING DEPENDENCIES (no cache)"
        echo "==============================="

        npm install --prefer-offline --no-audit --no-fund --cache /tmp/jenkins-npm-cache

        echo "==============================="
        echo " DEPENDENCIES INSTALLED"
        echo "==============================="
    """
}

return this

