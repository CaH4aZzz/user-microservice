#Users

This application is an example of microservice app of two microservices)). Which can obtain and display info about all the users or about specified user (by "username") form DB.

This particular project is a "server" app and the "client" app located on another Github repo(https://github.com/CaH4aZzz/user-microservice-ui).

##Install and run

**Docker and Maven required**

1. Clone or download repository from https://github.com/CaH4aZzz/user-microservice-ui.

2. Clone or download this repository to your local computer.

3. Go inside root directory of downloaded repo (`user-microservice`).

4. In the root dir perform command `mvn package`

5. In the root dir perform command `docker-compose up`

    Server-side listens to the port: 8123 inside the docker. Outside port configured to listen to : 8082.
    Client-side both inner and outer ports are 3000.

6. Go to http://localhost:3000/ on you computer.

##REST Api examples

**Get list of Users**

`GET /users/ http://localhost:3000/users/`

**Get User by id**

`GET /users/id http://localhost:3000/users/id`

**Get User by username**

`GET /users?username= http://localhost:3000/users?username=`

##Technologies

1. Maven

2. Java 8

3. Spring boot

4. H2 in-memory DB

5. JUnit 5 

6. Mockito

7. React

8. Bootstrap



