@echo on
@echo ***********************************************
SETLOCAL
#rem set JAVA_HOME=d:\apps\Java\jdk1.8
#rem set path=%path%+;%JAVA_HOME%\bin
START "hsql server" /B /MAX java -cp ./hsqldb-2.5.0.jar org.hsqldb.server.Server --database.0 file:data/db --dbname.0 db --port 5005
endlocal
exit
@echo ***********************************************
