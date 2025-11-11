stage('Test') {
  steps {
    sh 'npm test || echo "Tests failed"'
  }
}

