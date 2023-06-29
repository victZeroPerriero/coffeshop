node {
  stage("Clone the project") {
    git branch: 'master', url: 'https://github.com/victZeroPerriero/coffeshop.git'
  }

  stage("Compilation") {
    sh "./mvnw clean install -DskipTests"
  }

  stage("Tests and Deployment") {
    stage("Runing unit tests") {
      sh "./mvnw test -Punit"
    }
    stage("Deployment") {
      sh 'nohup ./mvn spring-boot:run &'
    }
  }
}