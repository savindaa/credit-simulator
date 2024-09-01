# Credit Simulator

## Description

This is a simple credit simulator application that calculates the monthly payment amount for a given loan amount, interest rate, and loan term.

## Dependencies

- Java version 11 or higher
- Maven
- Docker

## How to run console app mode

### Running the application

To run the application, you can execute the following command:

```bash
./credit_simulator
# or
./mvnw exec:java
# or
./mvnw clean package && java -jar target/credit_simulator-1.0-SNAPSHOT-jar-with-dependencies.jar
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

## How to run read from file mode

### Running the application

To run the application in read from file mode, you can execute the following command:

```bash
./credit_simulator input.csv
# or
./mvnw exec:java -Dexec.args="input.csv"
# or
./mvnw clean package && java -jar target/credit_simulator-1.0-SNAPSHOT-jar-with-dependencies.jar input.csv
```

## Read from file format

The input file should be a CSV file with the following format:

```
Tipe Kendaraan(motor/mobil),Keadaan Kendaraan(bekas/baru),Tahun Kendaraan,Jumlah pinjaman,Tenor pinjaman,Persentase DP
```

or can be seen in the example file `file_input.txt`:

```
motor,bekas,2019,10000000,12,20
```