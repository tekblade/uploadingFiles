# uploadingFiles
Uploading Images  with the browser
#Please README.md document
There are folowing worth to mention problems I met.
The path to the folder created makes very hard to manage images. 
# C:\Users\lukas\workspace\uploadingFiles\src\main\resources\images   - I recommend to change this path to suit your machine's local path
This one direcotry works properly with all controllers methods from "PictureUploadController".
BUT - thymeleaf showimage.html (Thymeleaf used) reads images to view in showimage.html script from path under build folder. 
I tried to manage it - much time spent- and I've abandoned it. My observations are that showimage.html reads data from previous application's runtime (under build subfolders).
The Controller works with specified path properly. The only problem is reading proper folder by showimage.html.
# Used: Gradle(STS)/Spring/Thymeleaf. JavaScript isn't used in the project.
# Application's start:
# CMD/Windows 10
# gradle wrapper
# gradlew bootrun  // starting the application Connecting: http://localhost:8080/upload
netstat -a -o -n => taskkill /F /PID <PID>  // Used to stop application
