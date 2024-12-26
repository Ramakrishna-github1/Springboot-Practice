pipeline {
    agent any
    tools {
            jdk 'JDK-21' // Replace 'JDK-21' with the name you gave your JDK 21 installation in Jenkins
        }
    stages {
        stage('Checkout') {
            steps {
                checkout changelog: false, scm: scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Ramakrishna-github1/Springboot-Practice.git']])
            }
        }
        stage('Set Permissions') {
                    steps {
                        sh 'chmod +x mvnw' // Crucial line
                    }
       }
        stage('Build') {
            steps {
                sh 'echo $JAVA_HOME'
                sh './mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test' // Or './gradlew test'
            }
        }
        stage('Code Coverage') {
            steps {
                jacoco(
                    execPattern: '**/jacoco.exec',
                    classPattern: '**/classes', // Important: Adjust if needed (e.g., '**/target/classes')
                    sourcePattern: 'src/main/java'
                )
            }
            post {
                always {
                   archiveArtifacts 'target/site/jacoco/index.html' // Archive the HTML report
                }
            }
        }
    }
    post {
        always {
            cleanWs() // Clean the workspace after the build
        }
    }
}