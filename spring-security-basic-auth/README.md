# Spring Security - Basic Authentication

## Technologies
- Spring Boot
- Spring Security

## How to test
1. Run
```shell
./mvnw spring-boot:run
```
2. Access browser

http://localhost:8080

3. Test unprotected pages
   1. http://localhost:8080/unprotected/data
   2. http://localhost:8080/unprotected/data/1
   
4. Test protected pages
   1. http://localhost:8080/protected/data
   2. http://localhost:8080/protected/data/1

5. Logout
   1. http://localhost:8080/logout