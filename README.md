# 🚀 Taskoro — Task Management Backend

Taskoro is a **Spring Boot-based task management system** designed to evolve from **core Java concepts to industry-level backend architecture**.

This project is being built in **phases**, where each phase introduces new backend engineering concepts and improves system design progressively.

---

# 🧠 Project Vision

Build a **Notion-like backend system** while:

* Practicing Java fundamentals
* Mastering Spring Boot ecosystem
* Understanding real-world backend architecture
* Becoming job-ready through incremental development

---

# 🏗️ Tech Stack

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **ModelMapper**
* **Maven**

---

# 🧱 Architecture

```
Controller → Service → Repository → Database
```

### Responsibilities:

* **Controller** → Handles HTTP requests
* **Service** → Business logic
* **Repository** → Database operations
* **Entity** → ORM mapping

---

# 📦 Project Structure

```
entity/
dto/
  ├── request/
  └── response/
repository/
service/
  ├── interface
  └── implementation
controller/
exception/
```

---

# 🔗 Domain Model

```
User
 └── Workspace
      └── Project
           └── Task
```

Optional:

```
Task → assignedUser
```

---

# ✅ Completed Phases

---

## 🟢 Phase 1 — Core CRUD

* Created 4 entities:

  * User
  * Workspace
  * Project
  * Task
* Implemented:

  * REST APIs (CRUD)
  * DTO pattern
  * Layered architecture

---

## 🔵 Phase 2 — Relationships

* Established entity relationships:

  * Workspace → User
  * Project → Workspace
  * Task → Project
  * Task → assignedUser
* Learned:

  * `@ManyToOne`
  * Foreign key ownership
  * Schema evolution

---

## 🟡 Phase 3 — Validation & Exception Handling

* Added:

  * Bean Validation (`@NotNull`, `@NotBlank`)
  * `@Valid` in controllers
* Implemented:

  * Custom Exception (`ResourceNotFoundException`)
  * Global Exception Handler (`@RestControllerAdvice`)
* Standardized error response:

```json
{
  "status": 400,
  "message": "Validation error"
}
```

---

## 🔴 Phase 4.1 — Pagination

* Implemented paginated API:

```
GET /tasks?page=0&size=5
```

* Learned:

  * `Pageable`
  * `Page<T>`
  * LIMIT / OFFSET (DB level)
* Improved scalability of API

---

# 🧪 API Testing

Tested using **Postman**:

* CRUD operations
* Relationship updates
* Validation errors
* Exception handling
* Pagination

---

# ⚠️ Key Learnings

* Correct update pattern:

```
load → modify → save
```

* Avoid:

  * Detached entities
  * Incorrect use of `merge`
* Always:

  * Use DTOs
  * Validate input
  * Handle errors centrally

---

# 🚀 Upcoming Phases

---

## 🔜 Phase 4.2 — Sorting & Filtering

* Sort by fields (createdAt, title)
* Filter tasks by project

---

## 🔜 Phase 4.3 — Search

* Search tasks by title
* LIKE queries

---

## 🔜 Phase 5 — Authentication

* Login system
* Password hashing (BCrypt)
* JWT authentication
* Secure endpoints

---

## 🔜 Phase 6 — Advanced Relationships

* OneToMany (read side)
* Bidirectional mapping
* Cascades

---

## 🔜 Phase 7 — Performance

* N+1 problem
* Fetch strategies
* DTO projections

---

## 🔜 Phase 8 — Deployment

* Docker
* Environment configs
* Cloud deployment

---

# 🧠 Goal

By the end of this project, the system will cover:

```
Backend Design → Data Modeling → Validation → Security → Performance → Deployment
```

---

# 📌 Status

✔ Phase 1 — Done
✔ Phase 2 — Done
✔ Phase 3 — Done
✔ Phase 4.1 — Done
🔜 Phase 4.2 — Next

---

# 🤝 Contribution

This project is being built as a **learning roadmap**.
Each phase improves architecture and adds new backend concepts.

---

# ⭐ Final Note

This is not just a project — it's a **complete backend engineering journey**.
