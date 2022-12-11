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
                script {
                           env.CONTAINER_ID = sh (
                               script: 'docker -H 172.17.0.2:2375 run -d --rm --name calculator archer999/calculator',
                               returnStdout: true
                           )
                       }
                sh "echo ${env.CONTAINER_ID}"
            }

        }

        stage ("Acceptance test") {
            steps {
               sleep 30
               script {
                   env.CONTAINER_IP = sh (
                       script: 'docker -H 172.17.0.2:2375 inspect ${CONTAINER_ID} | grep IPAddress | sort | grep IPAddress -m 1 | awk -F \'"\' \'{print \$4}\'',
                       returnStdout: true
                   ).trim()

               }
              //sh 'printenv'
              sh 'echo ${CONTAINER_IP}'
              sh 'chmod +x acceptance_test.sh && ./acceptance_test.sh'

            }
        }
        
        
        
    }

    post {
       always {
               echo "Email sent."
               /*  mail to: 'mapleupright@163.com',
                 subject: "Hello Completed Pipeline: ${currentBuild.fullDisplayName}",
               body: "you build completed please check: ${env.BUILD_URL}" */
               sh 'docker -H 172.17.0.2:2375 stop ${CONTAINER_ID}'

        }

    }
}
