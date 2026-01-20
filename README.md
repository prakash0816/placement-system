# 🎓 Student Placement System – Spring Boot REST API

A professional backend REST API built using **Spring Boot, Java, JPA, MySQL, Swagger, and Docker**.  
This project manages student records for placement purposes with full CRUD functionality and is publicly deployed.

---

## 🚀 Live Project

- 🌐 Live API Base URL:  
  https://placement-system-sohs.onrender.com

- 📘 Swagger API Documentation:  
  https://placement-system-sohs.onrender.com/swagger-ui/index.html

---

## ✨ Features

- Add Student  
- Get All Students  
- Get Student by ID  
- Search Students by Skill  
- Update Student  
- Delete Student  
- Input Validation (Jakarta Validation)  
- Global Exception Handling  
- Swagger OpenAPI Documentation  
- Dockerized Application  
- Deployed on Render (Public API)  

---

## 🛠️ Technologies Used

- Java 21  
- Spring Boot 3  
- Spring Data JPA  
- Hibernate  
- MySQL (Local Development)  
- H2 Database (Cloud Deployment)  
- Maven  
- Swagger OpenAPI  
- Docker  
- Git & GitHub  
- Render Cloud Platform  

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|---------|--------------|
| POST | `/students` | Add new student |
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| GET | `/students/search?skill=java` | Search students by skill |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |

---

## ▶️ Run Project Locally

### 1. Clone the repository
```bash
git clone https://github.com/prakash0816/placement-system.git
