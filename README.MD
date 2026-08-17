# TaskFlow API

TaskFlow is a REST API for task management built with Java, Spring Boot, Spring Data JPA, MySQL and Swagger/OpenAPI.
## API Documentation

![Swagger UI](docs/swagger.png)
## Features

- Create tasks
- Get all tasks
- Get a task by ID
- Update tasks
- Delete tasks
- Filter tasks by completion status
- Filter tasks by priority
- Filter tasks by status
- Search tasks by title
- Validation and error handling
- Swagger/OpenAPI documentation
- Automated service tests with JUnit and Mockito

## Task Status

Tasks can have one of the following statuses:

- `TODO`
- `IN_PROGRESS`
- `DONE`

## Priority

Tasks can use priorities such as:

- `LOW`
- `MEDIUM`
- `HIGH`

## Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger / OpenAPI
- JUnit 5
- Mockito

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |
| GET | `/api/tasks/status?completed=false` | Filter by completion status |
| GET | `/api/tasks/priority?value=HIGH` | Filter by priority |
| GET | `/api/tasks/search?title=Spring` | Search by title |
| GET | `/api/tasks/task-status?status=IN_PROGRESS` | Filter by task status |

## Example Task

```json
{
  "title": "Learn Spring Boot",
  "description": "Practice REST API development",
  "completed": false,
  "priority": "MEDIUM",
  "dueDate": "2026-08-25",
  "status": "IN_PROGRESS"
}
```

## Project Highlights

- RESTful CRUD API
- Layered architecture with Controller, Service and Repository
- MySQL persistence with Spring Data JPA
- Input validation and global exception handling
- Filtering by status, priority and completion
- Search by title
- OpenAPI / Swagger documentation
- Unit tests with JUnit 5 and Mockito

## Project Status

Completed as a portfolio backend project and ready for further improvements such as authentication, Docker and CI/CD.