void call() {
    sh """
        echo "Deploying Node.js app..."
        pkill -f "node index.js" || true
        nohup node index.js > app.log 2>&1 &
    """
}

