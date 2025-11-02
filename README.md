# **Spring Boot Realtime Notification Service**

##**Overview**
The **Spring Boot Realtime Notification Service** is a full-stack backend system designed to send and receive real-time notifications between users. It utilizes Spring Boot, Spring Security, JWT Authentication, and WebSocket technologies to provide secure, instant communication between clients. The project uses an H2 in-memory database for lightweight data storage and quick setup, making it ideal for learning and demonstration purposes.

##**Project Structure**
**Controller:**
Handles incoming HTTP and WebSocket requests, manages message broadcasting, and exposes REST endpoints for authentication and messaging.

**Entity:**
Defines the data models — such as User, Message, and Notification — along with their relationships using OneToOne and OneToMany mappings.

**Repository:**
Interfaces with the H2 database for CRUD operations on users and messages.

**Service:**
Contains business logic for user authentication, JWT token generation, and message handling.

**Security:**
Implements Spring Security with JWT for authentication and authorization. Configures AuthenticationManager, UserDetailsService, and PasswordEncoder.

**Application:**
The main entry point of the Spring Boot application.

##**Database Setup**

**Database:** H2 (in-memory database)

**Tables:**

**User:** Stores user details such as username, email, and encoded password.

**Message:** Stores messages exchanged between users.

**Notification:** Stores notification details for real-time updates.

##**Entity Relationships:**

One User → Many Messages (@OneToMany)

One Message → One Notification (@OneToOne)

##**Features**

**JWT Authentication:** Secure login system using JSON Web Tokens.

**Spring Security:** Role-based access control and password encryption using BCryptPasswordEncoder.

**WebSocket Integration:** Real-time message and notification updates between connected clients.

**REST API Endpoints:** Manage user registration, login, and message sending.

**Entity Mappings:** Demonstrates @OneToOne, @OneToMany, @ManyToOne relationships with proper cascade and fetch configurations.

**H2 Database Console:** In-memory database for testing and demo purposes (http://localhost:8080/h2-console).

##**API Endpoints**
**Method	Endpoint	Description**
**POST**	/api/auth/register	Register a new user
**POST**	/api/auth/login	Authenticate user and generate JWT token
**GET**	/api/messages	Retrieve all messages (Authenticated users only)
**POST**	/api/messages/send	Send a message to another user
**GET**	/ws	Establish WebSocket connection for live updates

##**Tools and Technologies Used**

**Java 17** – Core programming language.

**Spring Boot 3+** – Framework for building and running the application.

**Spring Security** – Provides authentication and access control.

**JWT (JSON Web Token)** – Secure token-based authentication mechanism.

**WebSocket** – Enables real-time two-way communication between users.

**Spring Data JPA** – ORM layer to interact with the H2 database.

**H2 Database** – Lightweight in-memory database for demo purposes.

**Maven** – Build automation and dependency management.

**Postman** – For API endpoint testing.

**IntelliJ IDEA** – IDE used for coding, running, and debugging the application.

##**Spring Initializr Dependencies**

1) Spring Web

2) Spring Boot DevTools

3) Spring Data JPA

4) Spring Security

5) H2 Database

6) JWT (io.jsonwebtoken)

7) Lombok

##**Conclusion**

This project showcases a complete, secure, and scalable real-time backend service with JWT authentication and live notifications using WebSocket. It’s an excellent foundation for building real-world applications like chat systems, live dashboards, or collaborative tools.

