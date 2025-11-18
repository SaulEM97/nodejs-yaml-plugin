def deployStage() {
    sh """
        echo "Deploying Node.js app with PM2..."

        # Install PM2 locally
        npm install pm2 --save-dev

        # Start or restart the app
        npx pm2 start index.js --name node-app || npx pm2 restart node-app

        # Save PM2 process list
        npx pm2 save

        # Detect server IP
        SERVER_IP=\$(hostname -I | awk '{print \$1}')

        echo "============================================"
        echo " Node.js app deployed successfully"
        echo " URL: http://\$SERVER_IP:3000"
        echo "============================================"
    """
}

return this

