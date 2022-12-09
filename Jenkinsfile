pipeline {
    
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        
         stage("Compile") {
            steps {
               sh "mvn compile"
            }
        }
        
         stage("Unit Test") {
            steps {
               sh "mvn test"
               publishHTML (target: [

                reportDir: 'target/site/jacoco',
                reportFiles:  'index.html,jacoco.csv',
                reportName: 'Jacoco Report'
               ])

                publishHTML (target: [

                               reportDir: 'target/',
                               reportFiles:  'checkstyle-result.xml',
                               reportName: 'checkstyle report'
                              ])
            }
        }
        
        
        
    }

    post {
        always {
            emailext body: "you build completed please check: ${env.BUILD_URL}",
                 subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
                 to: 'mapleupright@163.com'
        }

    }
}
