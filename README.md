
# 📝 Note Service — Spring Boot REST API

A simple REST service for managing **notes** and their **authors**

### 📌 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- H2 (in-memory database)
- Maven
- Lombok
- Swagger

---

### 🚀 Running the Project

#### Via IDE:
1. Clone the repository:
   ```bash
   git clone https://github.com/Puchinni/note-service.git
   cd note-service
   ```
2. Open the project in IntelliJ IDEA
3. Run the `NoteServiceApplication`

#### Via Command Line:
```bash
mvn spring-boot:run
```

---

### 🔗 Swagger UI

After running the project, visit:

```
http://localhost:8080/swagger-ui/index.html
```

---

### 💾 H2 Console

For viewing the data:

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb228`
- User: `sa`
- Password: `root`

---

### 📂 Project Structure

```
src
 └── main
     ├── java
     │    └── org.example
     │         ├── controller
     │         ├── model
     │         ├── repository
     │         ├── service
     │         └── NoteServiceApplication.java
     └── resources
          ├── application.properties
```

---

### 📚 API Endpoints

#### 👤 Authors

- `POST /authors` — Create a new author  
  **Request body:**
  ```json
  {
    "name": "John Doe"
  }
  ```

- `GET /authors` — Get all authors

- `GET /authors/{id}` — Get an author by ID

---

#### 🗒 Notes

- `POST /notes?authorId=1` — Create a new note  
  **Request body:**
  ```json
  {
    "title": "My first note",
    "content": "Some content"
  }
  ```

- `GET /notes` — Get all notes

- `GET /notes/{id}` — Get a note by ID

- `DELETE /notes/{id}` — Delete a note by ID

---

### ⚠️ Error Handling

Standard HTTP status codes are used for error responses:
- `404 Not Found` — if author/note not found
- `500 Internal Server Error` — for other failures

---


