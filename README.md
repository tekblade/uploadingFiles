There are folowing worth to mention problem I met:
The path to the folder created makes very hard to manage images 
----------------------------------------------------------------------------------------------------------------------
C:\Users\luce\workspace2\uploadingFiles\src\main\resources\static\images - I am recommending to change this path to suit your machine's local path
---------------------------------------------------------------------------------------------------------------------
The main problem is that this small application does read images from the previous applications run. Images counter does work properly in 
this application. For example try to upload 3 images and then stop this application. Run the application secound time and upload 3 images too to be sure Images counter does work properly: deduce is this: there will be shown images from previous applications run 

--------------------------------------------------------------------------------------
Steps to run application
# CMD/Windows 10
# gradle wrapper
# gradlew bootrun  // starting the application Connecting: http://localhost:8080/upload
# netstat -a -o -n => taskkill /F /PID <PID>  // Used to stop application

---------------------------------------------------------------------------------------- 
My recommendation:
there should be implemented servlet handler for images. or/and there is some security Issue
