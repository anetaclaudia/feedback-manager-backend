# feedback-manager-backend for Fujitsu Summer Internship 2021
Backend MVC for single-page application, which manages feedbacks. Created with Spring, for database I used H2.

## Running the project
The easiest way to run the program is using IntelliJ.

1. Download/Clone the project
2. Open it in IntelliJ. For any dependencies, which are needed by the project, are handled by Gradle. For H2 do the following:
   - In IntelliJ, select "Database" from the panel on the right.
   - Click the plus icon named "New"
   - Select data source H2 
   - In the url selection add `jdbc:h2:./h2/user
3. Run "RunApplication" file, which is found in src -> main -> java.
4. API can be accessed on localhost server address - localhost:8080/api/feedback

If you've backend up and running, then you should run the frontend project.
