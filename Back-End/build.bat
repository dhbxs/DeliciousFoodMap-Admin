@echo off
setlocal
echo.
@echo ^>^>^>^>^>^>^>     Package Task   ^<^<^<^<^<^<^<

echo.
REM "Display maven version"
@echo ========== Maven version ==========
call mvnw.cmd --version

echo.
REM "Run eclipse task"
@echo ========== Run eclipse task ==========
call mvnw.cmd clean package -DskipTests -Pbuild_war

echo.
@echo ^>^>^>^> Finish!

PAUSE>NUL
endlocal
@echo on