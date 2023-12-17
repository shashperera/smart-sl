# smartsl-api

# Description
This project is a Spring Boot application. It has following layers

## Domain layer
Layer that contains all Entities and DTO Objects to be used in the project.

when creating entity and dto classes make sure to add implements "Serializable". 
after implement Serializable in intellij IDE click class name and press Alt + Enter.
then it will suggest to auto generate serial value (if it is not working see this link https://mkyong.com/intellij/how-to-generate-serialversionuid-in-intellij-idea/).

##Repository layer
Layer that contains all repositories to be used in the project. used jpa repository in this module to communicate with DB

##Service layer
layer that contains project services/business logics. Which contains interfaces for each services
and the implementation of the service interface.

##Facade layer
layer that contains project service selector/delegator. Which contains interfaces for each facade and implementation of the facade interface.

##controller layer
It contains all rest api controllers
It follows the "http://localhost:8080/smartsl/****" according rest api.

## Test
Follow these instructions to execute application using embedded tomcat server:

* Generate project distribution using mvn clean install -DeskipTests command on Parent module.
* Then go to the main application file (SmartSlApplication.java) inside com.esad.smartsl package
* Open browser on http://localhost:8080 (server port can change in application.properties file)
* Use postman app to test the api
* you can find postman tested json file inside "postman_json" folder