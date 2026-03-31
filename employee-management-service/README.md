# 🚀 Employee Management Service

## 📌 Project Description

A **Spring Boot REST API** to manage employees, projects, and their assignments.
The application follows a layered architecture with **DTOs, validation, security, and testing** to ensure clean and scalable design.

---

## ✨ Features

### 👨‍💼 Employee Management

* Create employee
* Get all employees (with pagination)
* Get employee by ID
* Update employee score
* Delete employee
* Filter employees by:

  * Name
  * Project ID

### 📁 Project Management

* Create project
* Get all projects

### 🔗 Employee–Project Mapping

* Assign employees to projects during creation
* Many-to-Many relationship implemented

### 🔐 Security

* Role-based access control using Spring Security:

  * **HR** → Manage employees
  * **PM** → Manage projects
* Basic Authentication enabled

### ✅ Validation & Error Handling

* Input validation using Jakarta Validation
* Global exception handling with proper HTTP status codes

### 🧪 Testing

* Controller tests using MockMvc
* Service layer unit tests using Mockito
* Validation tests included

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Hibernate
* JUnit 5 & Mockito

---

## ⚙️ How to Run

1. Install MySQL and create database:

   ```sql
   CREATE DATABASE employee_db;
   ```

2. Update `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Access APIs using Postman or any REST client

---

## 🔑 Authentication

Basic Auth credentials:

| Role | Username | Password |
| ---- | -------- | -------- |
| HR   | hr       | 123      |
| PM   | pm       | 123      |

---

## 📡 API Endpoints

### 👨‍💼 Employees

* `POST /employees` → Create employee
* `GET /employees?page=0&size=5` → Get all employees (paginated)
* `GET /employees/{id}` → Get employee by ID
* `PUT /employees/{id}/score?score=90` → Update score
* `DELETE /employees/{id}` → Delete employee
* `GET /employees/filter?name=abc&projectId=1` → Filter employees

### 📁 Projects

* `POST /projects` → Create project
* `GET /projects` → Get all projects

---

## 🧱 Architecture

```
Controller → Service → Repository → Database
```

* **Controller** → Handles HTTP requests
* **Service** → Business logic
* **Repository** → Database operations

---

## 🧪 Testing Strategy

| Layer      | Tool           | Description          |
| ---------- | -------------- | -------------------- |
| Controller | MockMvc        | API testing          |
| Service    | Mockito        | Unit testing (no DB) |
| Validation | SpringBootTest | Validation testing   |

---

## 📈 Improvements Implemented

* Added DTO layer to avoid exposing entities
* Implemented validation annotations
* Added pagination and filtering
* Implemented role-based security
* Added global exception handling
* Improved test coverage (unit + integration)

---

## 👨‍💻 Author

**Tushar Chaudhari**

---

## ⭐ Final Note

This project demonstrates a **production-ready backend structure** with proper layering, validation, security, and testing practices.
