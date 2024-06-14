# Ruel.li Project
Welcome to the Ruel.li project! This repository hosts a comprehensive web application, composed of two primary subprojects: a backend developed in Java using Spring 3, and a frontend developed in Angular (version 17).

The front-end and back-end subprojects are independent (in a typical local environment you should start them separately).

Both subfolder contains a corresponding README.

This app proposes an authentication mechanism, using a JWT token. 

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
> npm i
> npm start
```

# License
This project is licensed under the MIT License. See the LICENSE file for details.
