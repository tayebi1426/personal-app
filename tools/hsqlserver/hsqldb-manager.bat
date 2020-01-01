SETLOCAL
#rem set JAVA_HOME=D:\apps\Java\jdk1.8
#rem set path=%path%+;%JAVA_HOME%\bin
start "hsqldbManager" /b java.exe -cp hsqldb-2.5.0.jar org.hsqldb.util.DatabaseManagerSwing
endlocal 