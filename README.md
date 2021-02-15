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
server.port = yourPostgresServerPort
spring.datasource.url = yourDataBaseURL
spring.datasource.username = yourPostgresUsername
spring.datasource.password = yourPostgresPassword
```
When app is up and running visit ```http://localhost:9999/home```
