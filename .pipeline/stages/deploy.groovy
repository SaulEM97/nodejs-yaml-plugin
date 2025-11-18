def deployStage() {
    sh """
        echo "Deploying Node.js app with PM2..."

        # Install PM2 if not installed
        if ! command -v pm2 >/dev/null 2>&1; then
            npm install -g pm2
        fi

        # Start or restart the app using PM2
        pm2 start index.js --name node-app || pm2 restart node-app

        # Save PM2 process list so it restarts on reboot
        pm2 save
    """
}

return this

