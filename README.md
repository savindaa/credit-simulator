# Credit Simulator

## Description

This is a simple credit simulator application that calculates the monthly payment amount for a given loan amount, interest rate, and loan term.

## Dependencies

- Java version 11 or higher
- Maven
- Docker

## How to run

### Running the application

To run the application, you can execute the following command:

```bash
./mvnw exec:java
```

### Running the tests

To run the tests, you can execute the following command:

```bash
./mvnw test
```

### Running the application with Docker

To build and run the application with Docker, you can execute the following command:

```bash
docker build -t credit-simulator .
docker run -it credit-simulator
```

### Running prebuilt Docker image

To run the prebuilt Docker image, you can execute the following command:

```bash
docker run -it --rm savinda/credit-simulator:latest
```
