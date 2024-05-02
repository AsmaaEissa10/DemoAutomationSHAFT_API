@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\jdk-21.0.2
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\Mohmmed\.m2\repository\allure\allure-2.26.0\bin;%path%
allure serve allure-results -h localhost
pause
exit