def packageApp(String FolderName) {
                steps {
                dir ("$FolderName") {
                script {
                    echo 'building the application'
                    sh 'mvn package'
                }
                }
                }
            
}
return this 
