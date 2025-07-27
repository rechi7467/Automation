pipeline {
    agent { label 'verisoft-2' }

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/rechi7467/Automation.git', description: 'Git repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'master', description: 'Branch name to build')
    }

    environment {
        BRANCH = "${params.BRANCH_NAME}"
    }

    triggers {
        cron('30 5 * * 1\n0 14 * * *')
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo "Cloning ${params.REPO_URL} (branch: ${params.BRANCH_NAME})"
                git branch: "${params.BRANCH_NAME}", url: "${params.REPO_URL}"
            }
        }

        stage('Compile') {
            options { timeout(time: 5, unit: 'MINUTES') }
            steps {
                echo "Starting compilation stage"
                sh 'mvn compile'
                echo "Compilation stage completed successfully"
            }
        }

        stage('Test') {
            options { timeout(time: 5, unit: 'MINUTES') }
            steps {
                echo "Starting test stage"
                sh 'mvn test'
                echo "Test stage completed successfully"
            }
        }
    }

    post {
        always {
            echo 'Post: always – This always runs no matter what'
        }
        success {
            echo 'Post: success – Build & Test completed successfully'
        }
        failure {
            echo 'Post: failure – Build or Test failed'
        }
    }
}
