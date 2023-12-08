# Microservices Architecture with Eureka Server

This project demonstrates a microservices architecture utilizing Eureka Server, comprising client service, cars service, and API gateways. Each service interacts with a distinct database, allowing for flexible configuration via the `application.properties` file.

## Setup

1. **Configure Databases**: Modify the `application.properties` file for each service to set up the desired database configurations.

2. **Launch Services**:
   - Start by launching the Eureka Server.
   - Proceed to start the Cars Service, Client Service, and API Gateway.

## Usage

Once the services are up and running, access the Eureka dashboard to verify successful service registration.

Eureka Dashboard![Eureka](https://github.com/mabouelkhir/abouelkhir_microservices/assets/101573892/c3848c7c-56b9-427e-b4f9-f3096660a232)


### Creating Data

Utilize the provided APIs to create cars and clients:

- Use the designated endpoints to create cars and clients via the respective services.

Create Cars API![add car](https://github.com/mabouelkhir/abouelkhir_microservices/assets/101573892/cfaa3f87-634c-410a-af23-acb03f0bb88b)

Create Clients API![add client](https://github.com/mabouelkhir/abouelkhir_microservices/assets/101573892/a5933416-b013-4490-92f1-ad03c0d17ef1)


### Viewing Results

To view the created data, access the endpoint `/clients/with-cars`:

- This endpoint will display the cars associated with each client.

Clients with Cars API![get](https://github.com/mabouelkhir/abouelkhir_microservices/assets/101573892/68c5f29a-f354-46a0-8ed4-4847d27fbdee)

