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
        
         stage("Unit Test and Package") {
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

        stage("Docker Imaging") {
            steps {
               sh "docker -H 172.17.0.2:2375 build -t archer999/calculator ."
            }
        }

        stage ("Prepare Test Environment") {
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

        stage ("Integration Test by Test Script") {
            steps {
               sleep 30
               script {
                   env.SERVER_IP = sh (
                       script: 'docker -H 172.17.0.2:2375 inspect ${CONTAINER_ID} | grep IPAddress | sort | grep IPAddress -m 1 | awk -F \'"\' \'{print \$4}\'',
                       returnStdout: true
                   ).trim()

               }

                script {
                                  env.SERVER_PORT = sh (
                                      script: 'docker -H 172.17.0.2:2375 container logs ${CONTAINER_ID} | grep \'Tomcat started\' | cut -c 124-128',
                                      returnStdout: true
                                  ).trim()

                              }
              //sh 'printenv'
              sh 'echo ${SERVER_IP}:${SERVER_PORT}'
              sh 'chmod +x acceptance_test.sh && ./acceptance_test.sh'

            }
        }

           stage ("Acceptance Test by Behavior") {
                     steps {
                       sh 'echo ${SERVER_IP}'
                       sh 'mvn failsafe:integration-test failsafe:verify -Dcalculator.url=http://${SERVER_IP}:${SERVER_PORT}'
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
