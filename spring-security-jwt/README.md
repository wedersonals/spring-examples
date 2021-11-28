# Spring Security - Authentication With JWT

## Technologies
- Spring Boot
- Spring Security
- JWT
- Loombok

## How to test
1. Run
```shell
./mvnw spring-boot:run
```
2. Access PostMan

3. Test unprotected page
    1. GET http://localhost:8080/status

4. Test protected pages
    1. GET http://localhost:8080/all-users

5. Login
   1. POST http://localhost:8080/login
   Change -> Body, raw, JSON:
      {
      "username": "admin",
      "password": "nimda"
      }
   
6. Reading data from protected url
   1. In headers of "5. Login", copy value of "Authorization"
   2. GET http://localhost:8080/all-users
   3. Change Authorization to "Bearer Token"
   4. Past value of "Authorization"
   5. Send


   

