# Megaverse

Api of the Megaverse Croosmint application

## Getting started

Clone the project into your environment

## Compile
- Compile the source code of the project
```
./mvnw compile
```

## Package
- Take the compiled code and package it in a Jar
```
./mvnw clean package
```

## Run application in local
```
./mvnw spring-boot:run
```

## Run application with docker
```
docker-compose up --build
```


# Endpoints:
## Build de Megaverse Map
```
http://localhost:8080/megaverse/build
```
cURL:
```
curl --location --request POST 'http://localhost:8080/megaverse/build'
```

## Reset de Megaverse Map
```
http://localhost:8080/megaverse/reset
```
cURL:
```
curl --location --request POST 'http://localhost:8080/megaverse/reset'
```


## Verify de Megaverse Map (if the actual Map is equals to the Goal Map)
```
http://localhost:8080/megaverse/verify
```
cURL:
```
curl --location --request POST 'http://localhost:8080/megaverse/verify'
```
