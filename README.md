# store-management
Create an API that acts as a store management tool- Create a Github profile if you don't have one

- Use git in a verbose manner, push even if you wrote only one class
- Create a Java, maven based project, Springboot for the web part
- No front-end, you can focus on backend, no need to overcomplicate the structure
- Implement basic functions, for example: add-product, find-product, change-price or others
- Optional: Implement a basic authentication mechanism and role based endpoint access
- Design error mechanism and handling plus logging
- Write unit tests, at least for one class
- Use Java 9+ features
- Add a small Readme to document the project

Precondition:

- Java 17
- PostgreSQL database

Information:

- The project contain a swagger where you can test the endpoints (no authorization)
- link: http://localhost:8080/swagger-ui/index.html
- 2 users are added at initialization via liquibase
- contained methods: save, get by ID, find All, change price
