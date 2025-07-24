# Task Planner - Microservices System  

![Architecture](https://img.shields.io/badge/Architecture-Microservices-blue)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-green)  
![Java](https://img.shields.io/badge/Java-17-orange)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)  
![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.0-purple)  
![Postman](https://img.shields.io/badge/Testing-Postman-FF6C37)  

## 📋 System Overview  

Planner is a full-featured task management system built on a microservices architecture using Spring Boot. The system provides:  

- Task management with priorities and categories  
- Task completion statistics  
- User management  
- Automatic test data generation  
- Service integration via Kafka  

## 🏗️ System Architecture  

### Core Microservices  

1. **planner-server** - Service registry (Eureka Server)  
2. **planner-gateway** - API Gateway (Spring Cloud Gateway)  
3. **planner-config** - Centralized configuration (Spring Cloud Config Server)  
4. **planner-users** - User management service  
5. **planner-todo** - Task management service  

### Additional Components  

- **Database**: PostgreSQL (split into planner_users and planner_todo)  
- **Message Broker**: Apache Kafka  
- **Caching**: Hibernate Second Level Cache  
- **Logging**: Aspect-oriented controller call logging  

## 🛠️ Technology Stack  

- **Java 17**  
- **Spring Boot 3.4.5**  
- **Spring Cloud 2024.0.1**  
- **PostgreSQL 15**  
- **Apache Kafka 3.0**  
- **Hibernate 6.0**  
- **Lombok**  
- **Feign Client**  
- **Resilience4j**  

## 📚 API Documentation  

### Key Endpoints (tested via Postman)  

#### Task Service (planner-todo)  
- `POST /task/add` - Add new task  
- `PUT /task/update` - Update task  
- `DELETE /task/delete/{id}` - Delete task  
- `POST /task/search` - Search tasks with filters  
- `POST /task/all` - All user tasks  

#### User Service (planner-users)  
- `POST /user/add` - Register new user  
- `PUT /user/update` - Update user data  
- `POST /user/deletebyemail` - Delete by email  
- `POST /user/search` - Search users  

#### Category Service (planner-todo)  
- `POST /category/add` - Add category  
- `POST /category/search` - Search categories  

#### Priority Service (planner-todo)  
- `POST /priority/add` - Add priority  
- `POST /priority/all` - All user priorities  

## 🚀 System Setup  

1. **Requirements**:  
   - Java 17  
   - PostgreSQL 15  
   - Apache Kafka  

2. **Startup Order**:  
   ```bash
   # 1. Start PostgreSQL and Kafka
   # 2. Start planner-config
   # 3. Start planner-server
   # 4. Start planner-users
   # 5. Start planner-todo
   # 6. Start planner-gateway
   ```

3. **Configuration**:  
   - Settings stored in centralized config server  
   - Profiles:  
     - `micro` - basic microservice settings  
     - `users`/`todo` - service-specific settings  
     - `logging` - logging settings  
     - `kafka` - Kafka integration settings  

## 🌟 Implementation Features  

1. **Service Integration**:  
   - Via Feign Client with error handling  
   - Via Kafka for async events (e.g., test data generation)  

2. **Caching**:  
   - Hibernate Second Level Cache for entities  
   - Various cache strategies (READ_ONLY, NONSTRICT_READ_WRITE)  

3. **Logging**:  
   - Aspects for logging controller method execution time  
   - Detailed SQL query logging  

4. **Error Handling**:  
   - Custom Feign Client handlers  
   - Detailed error messages  

## 📊 Postman Request Examples  

### Create User  
```http
POST http://localhost:8765/user/add
Content-Type: application/json

{
  "email": "test@example.com",
  "password": "password123",
  "username": "testuser"
}
```

### Create Task  
```http
POST http://localhost:8765/task/add
Content-Type: application/json

{
  "title": "Finish project",
  "completed": false,
  "userID": 1,
  "priority": {"id": 1},
  "category": {"id": 1}
}
```

### Get Statistics  
```http
POST http://localhost:8765/stat
Content-Type: application/json

1
```

## 📦 Project Structure  

```
planner-system/
├── planner-config/       # Configuration service
├── planner-gateway/      # API Gateway
├── planner-server/       # Eureka Server
├── planner-todo/         # Task service
├── planner-users/        # User service
└── planner-entity/       # Shared entities
```

## 💡 Future Development  

- Add JWT authorization  
- Implement Web UI  

## 📄 License  

MIT License
