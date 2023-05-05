def packageApp(String FolderName) {
     
                dir ("$FolderName") {
                script {
                    echo 'building the application'
                    sh 'mvn package'
                }
                }
            
}
return this 
