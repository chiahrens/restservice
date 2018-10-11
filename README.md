# Example spring boot app that connects to mongodb

## Quick Start 

### Pre-requisite
  * Download and run mongodb locally
  * Download and install maven, Java
  
### Instructions
  * mvn clean install
  * mvn spring-boot:run
  
### Test
Add person:
```
curl -X POST "localhost:8080/person" \
-H 'Content-Type: application/json' \
-d '{
  "firstName":"John",
  "lastName":"Doe"
}'
```

Get person
```
curl localhost:8080/person
```

## Components
walmart.com.App - Spring boot application initializer

walmart.com.MongoConfig - Initializes the connection to Mongodb

walmart.com.person.PersonRepositoryReactive - Spring initialized CRUD data accessor for mongodb

walmart.com.person.PersonController - Controller with routing annotations

walmart.com.person.Person - Pojo used both for mongo db (acting as a data access object) and for REST (acting as a transport object)
