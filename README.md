# JavaRest API

## Purpose

JavaRest is a simple RESTful API built with Spring Boot for managing user data. It provides endpoints to create, read, update, and delete users. The main entity is `User`, which includes fields for first name, last name, age, and email address.

## Features

- CRUD operations for users
- Search users by email address
- Built with Spring Boot and Spring Data JPA

## Setup

### Prerequisites

- Java 17 or newer
- Maven

### Installation

1. **Clone the repository**
   ```
   git clone <your-repo-url>
   cd javaRest
   ```

2. **Build the project**
   ```
   mvn clean install
   ```

3. **Run the application**
   ```
   mvn spring-boot:run
   ```
   Or run the jar directly:
   ```
   java -jar target/javaRest-0.0.1-SNAPSHOT.jar
   ```

## Usage

The API runs on [http://localhost:8080](http://localhost:8080).

### Example Endpoints

- `GET /users` — List all users
- `GET /users/{id}` — Get user by ID
- `POST /users` — Create a new user
- `PUT /users/{id}` — Update a user
- `DELETE /users/{id}` — Delete a user
- `GET /users/email/{emailAddress}` — Find user by email address

You can use [Postman](https://www.postman.com/) or `curl` to test the endpoints.

## Project Structure

- `Models/` — Entity classes (e.g., `User`)
- `Repo/` — Data access layer (e.g., `UserRepo`)
- `Controller/` — REST controllers
- `Service/` — Business logic

## License

This project serves for educational purposes
