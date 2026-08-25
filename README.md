# 🚀 Secure Task Flow Backend

A Spring Boot backend API for managing tasks with **role-based authentication and authorization** using Spring Security.  
Built with Java 8, Spring Boot, JPA, MySQL, and tested with Postman.


---

## 📌 Features

- 🧑‍💼 User Registration & Login
- 🔐 Role-based access control (`ROLE_USER` / `ROLE_ADMIN`)
- 🧾 Secure password encryption using BCrypt
- 📦 MySQL DB integration using Spring Data JPA
- 📤 RESTful APIs for authentication & task management
- ✨ DTO-based request handling for clean separation
- 👀 Secure access to endpoints using `@PreAuthorize`

---

## 🛠️ Tech Stack

- Java 8
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Maven
- Postman (for API testing)

---

## 🗃️ Folder Structure

src/main/java/com/securetaskflow
├── config # Spring Security config
├── controller # REST APIs
├── dto # Data Transfer Objects
├── entity # JPA Entities (User, Task)
├── repository # JPA Repositories
├── security # UserDetails implementation
├── service # Business logic
└── util # Utility classes

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8+
- MySQL installed & running
- IDE like STS / IntelliJ
- Postman

---

### 🔧 Setup Steps

1. **Clone the repo**
```bash
git clone https://github.com/kmagar-dev/secure-task-flow-backend.git
cd secure-task-flow-backend

spring.datasource.url=jdbc:mysql://localhost:3306/secure_task_flow
spring.datasource.username=root
spring.datasource.password=your_password

./mvnw spring-boot:run

{
  "username": "bittoo_admin",
  "password": "admin123",
  "role": "ROLE_ADMIN"
}
{
  "username": "bittoo_admin",
  "password": "admin123"
}
{
  "title": "Write README",
  "description": "Create professional documentation"
}
| Username       | Password   | Role         |
| -------------- | ---------- | ------------ |
| `bittoo_admin` | `admin123` | `ROLE_ADMIN` |
| `bittoo_user`  | `pass123`  | `ROLE_USER`  |

📌 Future Enhancements
🔐 JWT-based token authentication

🧪 JUnit test cases

🐳 Docker support

🧬 Swagger/OpenAPI integration

🙋‍♀️ Author
Khushboo Magar
📍 GitHub • LinkedIn

---


