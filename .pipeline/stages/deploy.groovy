def deploy() {
    sh """
        echo "Installing production dependencies..."
        npm install --production

        echo "Stopping existing Node process..."
        pkill -f "node index.js" || true

        echo "Starting Node.js app..."
        nohup node index.js > app.log 2>&1 &
    """
}
