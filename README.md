===========================================================

## Employee Registration Project with Spring boot CRUD Rest Api with MongoDB
```

Following Methods available:
1.  GET /api/employees -  Get all employee details
2.  GET /api/employees/get-emp/{id} - Get specific employee detail.
3.  POST /api/employees with data - Add New Employee to MongoDB
4.  PATCH /api/employees with data- Update existing employee
5.  DELETE /api/employees/delete-emp/{id} - Remove employee details from MongoDB.

# Prequisites
1.  Have Maven downloded and is in Path.
2.  Java 8
3.  MongoDB Installled.

# How to run this sample
1.  Download and extract this project.
2.  Start MongoDB with 
    ```
    mongod --dbpath data_directory_path
    ```
3.  Change your MongoDb configuration in src/java/resource/application.properties
4.  Go to CMD and run 
    mvn clean install
    ```

This is a Spring Boot project, so you can deploy it by simply using the main class: `SocGenApplication.java`
    ```
5.  Go to browser type http://localhost:8080/api/employees
