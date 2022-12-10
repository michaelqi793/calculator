pipeline {
    
    agent any
  /*   triggers {
        pollSCM('* * * * *')
    } */
    stages {
        
         stage("Clean") {
            steps {
               sh "mvn clean"
            }
        }
        
         stage("Package") {
            steps {
               sh "mvn package"
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

        stage("Docker imaging") {
            steps {
               sh "docker -H 172.17.0.2:2375 build -t archer999/calculator ."
            }
        }

        stage ("Stage test") {
            steps {
               sh "docker -H 172.17.0.2:2375 run -d -rm -p 8765:8081 --name calculator archer999/calculator"

            }

        }

        stage ("Acceptance test") {
            steps {
               sleep 100
               sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
            }
        }
        
        
        
    }

    post {
       always {
               echo "Email sent.";
               /*  mail to: 'mapleupright@163.com',
                 subject: "Hello Completed Pipeline: ${currentBuild.fullDisplayName}",
               body: "you build completed please check: ${env.BUILD_URL}" */
        }

    }
}
