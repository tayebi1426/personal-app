@echo on
@echo ***********************************************
SETLOCAL
set JAVA_HOME=d:\apps\Java\jdk1.8
set path=%path%;%JAVA_HOME%\bin;
START /B /MIN java -Xmx256m -cp ./hsqldb-2.5.0.jar org.hsqldb.server.Server --database.0 file:data/maindb --dbname.0 maindb --port 5005
endlocal
exit
@echo ***********************************************
