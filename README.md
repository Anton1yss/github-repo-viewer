# GitHub Repository Explorer | Test Task

---

### Table of Contents
- [Description](#description)
- [Installation](#installation)
- [Testing](#testing)

---

## Description

A **GitHub Repository Explorer** — small app built as a test task for ["Atipera"](https://www.linkedin.com/company/atipera/) during the recruitment process. Build with Java and Spring Boot, providing an API to browse public GitHub repositories and their branches.

- **Repository Listing:** Fetch all non-forked repositories for a given GitHub user;
- **Branch Info:** Retrieve all branches with the latest commit SHA for each repository;
- **Error Handling:** Returns proper HTTP responses for non-existent users;

**Technical stack:** Java 21, Spring Boot, Spring Web, Lombok, Swagger.

---

## Installation

1️⃣ Clone the repository to your local directory:
```bash
git clone https://github.com/твій-юзернейм/github-repository-explorer
```

2️⃣ Navigate to the project directory:
```bash
cd github-repository-explorer
```

3️⃣ Start the Application:
```bash
./mvnw spring-boot:run
```

---

## Testing

Once the App is running, access the **API documentation** through **Swagger UI** at:  
**http://localhost:8080/swagger-ui/index.html**

### Example request:
```bash
GET /getAllUserRepos?username=torvalds
```

### Example response:
```json
[
  {
    "name": "example",
    "owner": { "login": "example" },
    "branches": [
      { "name": "master", "commit": { "sha": "abc123" } }
    ]
  }
]
```

### Error response (user not found):
```json
{
  "status": 404,
  "message": "User example not found"
}
```
