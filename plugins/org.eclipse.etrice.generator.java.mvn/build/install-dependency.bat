mvn org.apache.maven.plugins:maven-install-plugin:2.5.1:install-file  ^
-Dfile=%SRC_INSTALLATION%\plugins\%2_%3.%4.jar ^
-DgroupId=%1 ^
-DartifactId=%2 ^
-Dversion=%3 ^
-Dpackaging=jar ^
-Dpom=true
