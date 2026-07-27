@echo off
REM Builds SmpCore and copies the jar into the server's plugins folder.
REM Maven and the JDK are both local to this project - nothing is installed system-wide.

set "JAVA_HOME=F:\smp\jdk\jdk-25.0.3+9"
set "MVN=F:\smp\tools\apache-maven-3.9.16\bin\mvn.cmd"

pushd "%~dp0"
call "%MVN%" clean package
if errorlevel 1 (
  echo.
  echo BUILD FAILED - jar was NOT copied.
  popd
  pause
  exit /b 1
)

copy /Y "target\SmpCore.jar" "F:\smp\plugins\SmpCore.jar"
echo.
echo Done. SmpCore.jar copied to F:\smp\plugins\
echo Restart the server (or run: reload confirm) to load it.
popd
pause
