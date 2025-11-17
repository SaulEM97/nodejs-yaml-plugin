pipeline {
    stages {
        stage('build') {
            steps {
                build.run()
            }
        }

        stage('test') {
            steps {
                test.run()
            }
        }

        stage('deploy') {
            steps {
                deploy.run()
            }
        }
    }
}
