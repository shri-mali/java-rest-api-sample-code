# java-rest-api-sample-code

The sample application contains backend REST APIs needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

functionality:
- View account list: /api/accounts/USER_ID
- View account transactions: /api/accounts/USER_ID/ACCOUNT_NUMBER

Sample application contain 3 users with ids: 1,2 and 3.

- To view accounts of user with id 1, navigate to http://localhost:8080/api/accounts/1
- To view transactions of account 123, navigate to http://localhost:8080/api/accounts/1/123

# Prerequisites
- JDK 1.8
- Maven

# Installation Instructions
1. Download and extract Zip File
2. Open cmd and navigate to extracted files
3. Run "mvn clean install" 
4. Run "java -jar target/java-rest-api-sample-code-1.0-SNAPSHOT.jar"


# Testing
To test the application, please run "mvn test"
