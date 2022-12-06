pipeline {
    
    agent any
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
                reportName: 'Jacoco p Report'
               ])
            }
        }
        
        
        
    }
}
