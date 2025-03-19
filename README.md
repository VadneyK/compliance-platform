# Compliance Platform

A Spring Boot application for managing financial transactions with compliance checks.

## Features

- Transaction management
  - Create new transactions
  - Retrieve all transactions
- Validation rules
  - Transaction ID is required
  - Amount must be positive
- Comprehensive test coverage
  - Unit tests
  - Integration tests

## API Endpoints

- `POST /api/transactions` - Create a new transaction
- `GET /api/transactions` - Retrieve all transactions

## Running the Application

```bash
mvn spring-boot:run
```

## Running Tests

```bash
mvn test
```
