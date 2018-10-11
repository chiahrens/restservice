# Example spring boot app that connects to mongodb

## Pre-requisite
  * Download and run mongodb locally
  * Download and install maven, Java
  
## Instructions
  * mvn clean install
  * mvn spring-boot:run
  
## Test
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
