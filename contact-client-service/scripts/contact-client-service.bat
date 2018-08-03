@echo off
 setLocal EnableDelayedExpansion
 set CLASSPATH="
 for /R ./lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
 )
 set CLASSPATH=!CLASSPATH!"
 echo !CLASSPATH!
 
 set /p port=Please input server port (advised range: 8870 - 8875):

java -Dserver.port=%port% -jar lib/contact-client-service-1.0.0.BUILD-SNAPSHOT.jar

pause 