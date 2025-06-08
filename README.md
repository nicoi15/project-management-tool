Project management tool [Spring Boot](http://projects.spring.io/spring-boot/) app.

## Requirements

For building and running the application, you need:

- [JDK 17]
- [Maven 3]

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `org.adaca.exam.adacaexamprojectmanagementtool.Application` class from your IDE.

## Data persistence

- Used H2 database for this application
- To modify the database manually, go to this URL in your browser (http://localhost:9090/api/v2/h2-console) while the spring boot app is running
- Some dummy data is already inserted using Flyway migration

