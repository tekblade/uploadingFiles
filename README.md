There are folowing worth to mention problem I met:
The path to the folder created makes very hard to manage images 
----------------------------------------------------------------------------------------------------------------------
C:\Users\luce\workspace2\uploadingFiles\src\main\resources\static\images - I am recommending to change this path to suit your machine's local path
---------------------------------------------------------------------------------------------------------------------
The main problem is that this small application does read images from the previous applications run. 
Steps to run application
# CMD/Windows 10
# gradle wrapper
# gradlew bootrun  // starting the application Connecting: http://localhost:8080/upload
# netstat -a -o -n => taskkill /F /PID <PID>  // Used to stop application
---------------------------------------------------------------------------------------- 
My recommendation:
You should implement servlet handler for images
