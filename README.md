Tennis Scoring System
=

#### Requirements:

 - This solution is built with Java 11 (OpenJDK).
 - Run `brew cask install java` to get Java 11 if you are on macOS.  
 - Run `brew install maven` to get Maven

#### Future Changes:

Due to time constraints, these were not implemented yet:

- Dependency Injection
- Use Mocks instead of real objects in Scorer tests
 
#### Assumptions:

- The program assumes the client passes in correct data. Eg. Null values for the input are not handled and might break the application.
- The program works correctly only for the first set. As soon as the first set is complete, further scores will be incorrect. 

To run tests:

> mvn test