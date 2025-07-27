pipeline {
    agent { label 'verisoft-2' }

    // פרמטרים שהמשתמש יכניס בג'נקינס
    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/your-username/JenkinsPipelinesProject', description: 'Git repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch name to build')
    }

    // משתני סביבה קבועים לפייפליין
    environment {
        BRANCH = "${params.BRANCH_NAME}"
    }

    // טריגרים להפעלה אוטומטית לפי לוח זמנים
    triggers {
        cron('TZ=Asia/Jerusalem\n30 5 * * 1\n00 14 * * *')
    }

    stages {

        // שלב ראשון: הורדת הקוד מה-repo וה-branch שצוינו
        stage('Clone Repository') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Cloning ${params.REPO_URL} (branch: ${env.BRANCH})"
                    git branch: "${env.BRANCH}", url: "${params.REPO_URL}"
                }
            }
        }

        // שלב שני: קומפילציה עם Maven
        stage('Compile') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting compilation stage"
                    sh 'mvn compile'
                    echo "Compilation stage completed successfully"
                }
            }
        }

        // שלב שלישי: הרצת טסטים
        stage('Test') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "Starting test stage"
                    sh 'mvn test'
                    echo "Test stage completed successfully"
                }
            }
        }
    }

    // בלוק post - הדפסות לפי סטטוס הבנייה
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
