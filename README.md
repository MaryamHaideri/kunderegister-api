# Customer Register API

A REST API built with Java and Spring Boot for managing customer information. This project demonstrates backend development, object-oriented programming, RESTful services, input validation, and exception handling.

## Features

- Create new customers
- Retrieve all customers
- Retrieve a customer by ID
- Search customers by name
- Delete customers by ID
- Validate customer input
- Handle errors and return appropriate HTTP status codes

## Technologies

- Java
- Spring Boot
- Spring Web
- Jakarta Validation
- Maven
- IntelliJ IDEA

## Project Structure

The application is organized into separate layers to keep the code structured and maintainable.

- **Customer:** Represents customer information.
- **CustomerController:** Handles HTTP requests and API endpoints.
- **CustomerService:** Contains the business logic.
- **GlobalExceptionHandler:** Handles validation errors and other exceptions.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/customers` | Get all customers |
| GET | `/api/customers/{id}` | Get customer by ID |
| GET | `/api/customers/search?name=Ola` | Search customers by name |
| POST | `/api/customers` | Create a new customer |
| DELETE | `/api/customers/{id}` | Delete customer by ID |

## Example: Create a Customer

**POST** `/api/customers`

Request body:

```json
{
  "name": "Ola Nordmann",
  "phone": "41234567",
  "email": "ola@example.com",
  "note": "Test customer"
}
```

## Run the Application

1. Clone the repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

2. Open the project in IntelliJ IDEA.

3. Make sure Java and Maven are installed.

4. Run the main application class:

`KunderegisterApiApplication.java`

The application starts on:

`http://localhost:8080`

## Testing

API endpoints can be tested using PowerShell, Postman, or another HTTP client.

The project includes input validation and error handling for invalid requests and customers that cannot be found.

## Future Improvements

- Add database integration
- Implement automated unit and integration tests
- Add customer update functionality (PUT)
- Add API documentation with Swagger
