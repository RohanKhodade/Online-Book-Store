# 📚 Online Book Store - Spring Boot

An online book store application built using **Java Spring Boot**, featuring full CRUD operations for both **Books** and **Users**, with secure authentication and role-based access control.

---

## 🚀 Features

- ✅ **CRUD Operations**
  - Add, update, delete, and view books
  - Manage user accounts (Admin/User)
  
- 🔐 **Spring Security**
  - Role-based access control (Admin & User)
  - Authentication and authorization
  
- 🛠️ **Three-Layer Architecture**
  - **Controller**: Handles HTTP requests and responses
  - **Service**: Business logic layer
  - **Repository**: Handles database persistence using Spring Data JPA
  
- 🌐 **RESTful APIs**
  - Exposes endpoints for frontend integration
  - JSON-based communication
  
- ⚡ **Scalable & Secure**
  - Input validation
  - Password encryption
  - Error handling

---

## 🏗️ Project Structure
│── src/main/java/com/bookstore
│ ├── controller/ # REST Controllers
│ ├── service/ # Service Layer
│ ├── repository/ # Repository Layer
│ ├── model/ # Entities (Book, User, Roles)
│ ├── security/ # Spring Security Config
│ └── OnlineBookStoreApplication.java
│
│── src/main/resources/
│ ├── application.properties
│ └── data.sql (optional for sample data)
│
└── pom.xml
