# Ruel.li Project
Welcome to the Ruel.li project! This repository hosts a comprehensive web application, composed of two primary subprojects: a backend developed in Java using Spring 3, and a frontend developed in Angular (version 17).

Both front-end and back-end are independant (in a typical local environment, you should start separatly).

Both subfolder contains a corresponding README.

## Backend
To start the backend you will need a JDK, navigate to the backend folder and use maven : 
```
> cd backend
> ./mvnw clean install
> ./mvnw spring-boot:run
```

## Frontend
To start the frontend you will need Node and Angular CLI tool.
```
> cd frontend
> ng serve --proxy-config proxy.json
```

# License
This project is licensed under the MIT License. See the LICENSE file for details.
