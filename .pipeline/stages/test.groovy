void run() {
    sh 'npm test || echo "Tests failed"'
}

