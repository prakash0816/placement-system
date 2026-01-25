# Student Information Management System

A full-stack web application built using Spring Boot, MySQL, HTML, CSS, and JavaScript to manage student records in a simple and efficient way.

This project supports Admin and Student login, allows managing student data, and demonstrates real-world backend architecture.

---

## Features

Admin:
- Add new student
- View all students
- Delete students
- Search students by roll number, department, and year

Student:
- View all students
- Search students
- View profile page

Authentication:
- Login system for Admin and Student
- Passwords encrypted using BCrypt

---

## Technologies Used

- Java (Spring Boot)
- Spring Data JPA (Hibernate)
- MySQL
- HTML, CSS, JavaScript
- Maven
- IntelliJ IDEA

---

## Project Structure

com.mca.student_system  
├── config  
├── controller  
├── exception  
├── model  
├── repository  
├── service  
└── StudentInformationManagementApplication.java

Frontend files:

src/main/resources/static/  
login.html  
dashboard.html  
student.html  
style.css  
script.js

---

## How to Run

1. Clone the project

git clone https://github.com/prakash0816/student-information-management-system.git

2. Create MySQL database

CREATE DATABASE placement_db;

3. Configure database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/placement_db  
spring.datasource.username=root  
spring.datasource.password=Prakash@08

4. Run application

mvn spring-boot:run

or run directly from IntelliJ IDEA.

---

## Application URLs

Login Page  
http://localhost:8080/login.html

Admin Dashboard  
http://localhost:8080/dashboard.html

Student Page  
http://localhost:8080/student.html

API Endpoint  
http://localhost:8080/api/students

---

## Sample Login Credentials

Admin  
Email: admin@gmail.com  
Password: admin123

Student  
Email: student@gmail.com  
Password: 123

(You can change credentials from the database)

---

## Author

Jaya Prakash  
GitHub: https://github.com/prakash0816
