@echo off

set "CURRENT_DIR=%cd%"
cd ..
set "ServerHome=%cd%"
java -jar %ServerHome%/lib/myserver.jar %ServerHome% 8000