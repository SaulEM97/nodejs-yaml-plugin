stage('build') {
    build.run()
}

stage('test') {
    test.run()
}

stage('deploy') {
    deploy.run()
}
