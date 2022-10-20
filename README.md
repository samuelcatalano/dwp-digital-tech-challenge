# Bpdts Code Challenge - Samuel Catalano
Technical Challenge

### How to compile application:
> `mvn clean install`

### Stack:
| Technology | Version |
|--|--|
| **Java** | "11.0.3" 2018-01-14 |
| **Spring Boot** | 2.2.5.RELEASE |
| **Project Lombok** | Stable |

### How to run the application:
> Run via IDE (IntelliJ, Eclipse, NetBeans):
- Importing the project as Maven project on your favourite IDE.
- Build project using Java 11
- Run/Debug project from Main Application Class :: BpdtsChallengeApplication

> Run via terminal:
- `mvn spring-boot:run`

> Run Tests:
- `mvn test`

### Acessing Swagger | Open API:
Once with the application running:
http://localhost:8080/swagger-ui.html

### APIs:
> People living in London
* GET: http://localhost:8080/api/user/users-city/London

> People whose current coordinates are within 50 miles of London (including London)
* GET: http://localhost:8080/api/user/all-users

**Docker**

Exists a Dockerfile prepared to download a OpenJDK 11 Slim and install the application.

- Run the command: `docker build -t bpdts/challenge:release .`
- Run the command: `docker run -p port:port <IMG_TAG>`
- Example: `docker run -p 8080:8080 8fb870f41548`
- Or download the image `docker pull samueldnc/samuelcatalano:bpdts`
