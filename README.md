# feedback-manager-backend for Fujitsu Summer Internship 2021
Backend MVC for single-page application, which manages feedbacks. Created with Spring, for database I used H2.

## Prerequisites
Make sure you have atleast Java 11 on your device and environment variables set. 

## Running the project
The easiest way to run the program is using IntelliJ, but you can run the project from command line as well.

### Running the project in IntelliJ
1. Download/Clone the project
2. Open it in IntelliJ. For any dependencies, which is needed by the project, are handled by Gradle. 
3. Run "RunApplication" file, which is found in src -> main -> java.
4. To check, if the project is up and running, go to `localhost:8080/api/category` from your browser. It should display the list of categories. To access the feedbacks (which are sent from the front), you can see them on `localhost:8080/api/feedback`.

### Running the project from command line
1. Switch into the feedback-manager-backend project folder.
2. Run `gradlew bootRun` from the command line.
3. To check, if the project is up and running, see no. 4 under "Running the project in IntelliJ"

If you've backend up and running, then you should run the frontend project.
