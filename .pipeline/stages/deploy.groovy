def deployStage() {
    sh """
        echo "Deploying Node.js app with PM2 (local install)..."

        # Install PM2 locally in the workspace
        npm install pm2 --save-dev

        # Start or restart using PM2 through npx
        npx pm2 start index.js --name node-app || npx pm2 restart node-app

        # Save PM2 process list
        npx pm2 save
    """
}
return this

