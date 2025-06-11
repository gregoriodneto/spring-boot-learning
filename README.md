# Spring Boot Learning

Este repositório contém exemplos práticos e notas de estudo para aprender o Spring Boot e tecnologias relacionadas.

## ✅ Tópicos Cobertos

### 🔹 Fundamentals
- ✅ Dependency Injection and Beans
- ✅ Core annotations:
    - `@Component`
    - `@Service`
    - `@Repository`
    - `@Controller`
    - `@RestController`

### 🌐 REST API Development
- ✅ CRUD with `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- ✅ DTOs and validations with `@Valid`, `@NotNull`

### 🗃️ JPA / Hibernate
- ☐ Entity mappings: `@Entity`, `@OneToMany`, `@ManyToOne`
- ☐ Repositories with `JpaRepository`

### ⚠️ Error Handling
- ☐ Global exception handling with `@ControllerAdvice`, `@ExceptionHandler`

### 🔐 Security
- ☐ Basic Spring Security (JWT, simple authentication)

### 🧪 Testing with Spring
- ☐ Unit and integration testing using:
    - `@WebMvcTest`
    - `@DataJpaTest`
    - `MockMvc`

### 📘 API Documentation
- ☐ Generate API docs using `springdoc-openapi` (Swagger UI)

### 🚀 Deployment
- ☐ Packaging with Maven and running in containers
- ☐ Deployment to Heroku or Render (free tier)

### 🔧 Extra Tools (Advanced - Optional)
- ☐ **Messaging**: RabbitMQ, Kafka
- ☐ **Cloud (AWS Basics)**: S3, EC2, RDS, IAM
- ☐ **Docker**: Containerizing the application
- ☐ **Kubernetes**: Basic orchestration concepts

## 🛠️ Como Rodar
```bash
./mvnw spring-boot:run