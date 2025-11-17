void run() {
    echo 'Deploying Node.js app...'
    sh '''
        scp -r . user@server:/var/www/nodeapp
        ssh user@server "pm2 restart nodeapp"
    '''
}

