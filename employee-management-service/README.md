# Employee Management Service

## Project Description
This is a Spring Boot REST API to manage employees, projects, and assignments.

---

## Features
- Create and fetch employees
- Create and fetch projects
- Assign and unassign employees to projects
- Update employee score
- Role-based access control (HR, PM)

---

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL

---

## How to Run
1. Install MySQL
2. Create database:
   CREATE DATABASE employee_db;
3. Update application.properties with DB username/password
4. Run the Spring Boot application
5. Use Postman to test APIs

---

## Roles
- HR → Can create employees
- PM → Can assign/unassign employees
- Auth → Basic authentication is used

---

## API Examples
- POST /employees
- GET /employees
- POST /projects
- POST /assign