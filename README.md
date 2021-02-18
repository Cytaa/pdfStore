## Web app that that stores pdf in db.

### Technologies
* Spring
* PostgreSQL
* Thymeleaf
* Maven

### How to get it?
Just copy and run commands from below

```
git clone https://github.com/Cytaa/pdfStore.git
```

After downloading it you will have to change ```application.properties```
to match your postgreSQL. Here's how to do it.
```
server.port = portToSetUpFrontEndOn
spring.datasource.url = yourDataBaseURL
spring.datasource.username = yourPostgresUsername
spring.datasource.password = yourPostgresPassword
```
### How to run it?

To run use following commands in projects folder

```
mvn package
mvn spring-boot:run
```

When app is up and running visit ```http://localhost:portToSetUpFrontEndOn/home```
