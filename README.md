# Sample REST API with Spring Boot, Maven and java

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/fsaldanha-it/tasklist.git
```

**2. Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-rest-api-tasks-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following APIs.

    http://localhost:8080/api/v1/allTasks
    
    http://localhost:8080/api/v1/taskTodo
    
    http://localhost:8080/api/v1/taskId/{id}
    
    http://localhost:8080/api/v1/addTask/{label}
    
    http://localhost:8080/api/v1/updateTaskStatus/{id}

