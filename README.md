# 🎮 Profile Matcher Service 🚀

The **Profile Matcher Service** is a Spring Boot application designed to match player profiles with active campaigns and update their profiles accordingly. It provides RESTful APIs to retrieve and update player profiles based on campaign conditions.

---

## ✨ **Key Features**
- 👤 Retrieve player profiles by their unique ID.
- 🎯 Match player profiles with active campaigns based on predefined conditions.
- 🔄 Update player profiles with active campaign information.
- 🧪 Mocked external service to simulate campaign data.
- 💾 H2 in-memory database for testing and development.
- 🧱 Modular architecture with services, facades, and repositories.

---

## 🛠️ **Technologies Used**
- **☕ Java 17**
- **🌱 Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Security (future enhancement)
- **📄 H2 Database** (in-memory)
- **🧪 JUnit 5** (for unit and integration testing)
- **🎭 Mockito** (for mocking dependencies)
- **📌  Log4j 2** (for logging)

---

## 🚀 **Getting Started**

### ⚙️ **Prerequisites**
- Java 17 or higher
- Maven 3.8 or higher

### 🏃 **Running the Application**
1.  Build the project:
    ```bash
    mvn clean install
    ```

2. Run the application:
    ```bash
    mvn spring-boot:run
    ```

4. Access the application:

   - **API Base URL:** `http://localhost:9191/api/v1/player`
   - **H2 Console:** `http://localhost:9191/h2-console` (username: `sa`, password: `empty`)

### Player API Endpoints
| HTTP Method | Endpoint                                      | Description                                                   |
|-------------|----------------------------------------------|---------------------------------------------------------------|
| `POST`      | `/api/v1/player/get_client_config/{playerId}` | Retrieves and updates the player profile based on active campaigns. |

### 🗄️ Database Schema
#### Tables
- `PLAYERS`: Stores player information.
- `PLAYER_PROFILES`: Stores player profile details.
- `PLAYER_SESSION`: Stores session details for players.
- `PLAYER_INVENTORY`: Stores player inventory details.
- `GAME_ITEMS`: Stores game item details.
- `INVENTORY_ITEMS`: Stores inventory items for players.
- `PLAYER_STORES`: Stores player store transactions.
- `DEVICES`: Stores device information.
- `FIRMWARES`: Stores firmware details for devices.
- `CARRIERS`: Stores carrier information.
- `PLAYER_DEVICES`: Stores player-device relationships.
- `CLANS`: Stores clan information.

### 🧪 Testing
#### Unit Tests
Unit tests are located in the `src/test/java/com/example/profile_matcher/manager/service/impl` and `src/test/java/com/example/profile_matcher/manager/facade/impl` directories.

#### Integration Tests
Integration tests are located in the `src/test/java/com/example/profile_matcher/manager/controller` directory.

#### Run all tests:
        mvn test

---

### 🚀 **Future Enhancements**
- 🛡️ Add Spring Security for authentication and authorization.
- 📄 Implement Swagger/OpenAPI for API documentation.
- ➡️ Add pagination for large datasets in API responses.
- ⚠️ Enhance error handling with custom exception classes.
- ⏳ Add caching for frequently accessed data.
- 🐳 Implement Docker for containerized deployment.