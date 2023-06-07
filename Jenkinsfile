// node(){

// 	def sonarHome = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	
// 	stage('Code Checkout'){
// 		checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubCreds', url: 'https://github.com/anujdevopslearn/MavenBuild']])
// 	}
// 	stage('Build Automation'){
// 		sh """
// 			ls -lart
// 			mvn clean install
// 			ls -lart target

// 		"""
// 	}
	
// 	stage('Code Scan'){
// 		withSonarQubeEnv(credentialsId: 'SonarQubeCreds') {
// 			sh "${sonarHome}/bin/sonar-scanner"
// 		}
		
// 	}
	
// 	stage('Code Deployment'){
// 		deploy adapters: [tomcat9(credentialsId: 'TomcatCreds', path: '', url: 'http://54.197.62.94:8080/')], contextPath: 'Planview', onFailure: false, war: 'target/*.war'
// 	}
// }





pipeline {
    agent {
		label "JenkinsSlave"
	}
    stages {
        stage('Code Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubCreds', url: 'https://github.com/anujdevopslearn/SonarQubeNodeJS.git']])
            }
        }
		stage('Code Build') {
            steps {
                echo 'Code Build'
				sh """
					ls -lart
					npm install
					npm run build
				"""
            }
        }
		stage('Test Automation') {
            steps {
                echo 'Test Automation'
				sh """
					npm run test
					npm run test:e2e
				"""
            }
        }
		stage('Code Deployment') {
            steps {
                echo 'Code Deployment'
            }
        }
    }
	post {
		success {
			echo "Build is Success !!!!"
		}
		
        failure {    
			echo "Build is Failure !!!!"
        }
		always {
			emailext attachLog: true, 
                body: "$JOB_NAME - Build # $BUILD_NUMBER - $currentBuild.currentResult :\nCheck console output at $BUILD_URL to view the results.", 
                compressLog: true, subject: "$JOB_NAME - Build # $BUILD_NUMBER - $currentBuild.currentResult !", to: 'louisdarius96@yahoo.fr'
		}
    }
}
