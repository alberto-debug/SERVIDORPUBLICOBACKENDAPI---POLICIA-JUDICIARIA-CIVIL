# Servidor Público API
Polícia Judiciária Civil — Backend

<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"></img>
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"></img>
<img src="https://img.shields.io/github/license/alberto-debug/SERVIDORPUBLICOBACKENDAPI---POLICIA-JUDICIARIA-CIVIL?style=for-the-badge" alt="Licence"></img>

This project is a RESTful API built with Java and Spring Boot to manage public servants (efetivo and temporário), organizational units and lotações for the Polícia Judiciária Civil.

## Table of Contents
- Installation
- Configuration
- Usage
- API Endpoints (examples)
- Database
- Contributing

## Installation
Clone the repository:

```bash
git clone git@github.com:alberto-debug/SERVIDORPUBLICOBACKENDAPI---POLICIA-JUDICIARIA-CIVIL.git
cd SERVIDORPUBLICOBACKENDAPI---POLICIA-JUDICIARIA-CIVIL
```

Build with Maven (wrapper included):

```bash
./mvnw clean package
# or run directly
./mvnw spring-boot:run
```

Notes:
- The project uses the Java version configured in `pom.xml` (property `java.version`). Make sure your `JAVA_HOME` points to a compatible JDK.

## Configuration
Example minimal `src/main/resources/application.properties` values you may want to set or override in your environment:

```properties
spring.application.name=ServidorPublicoAPI

# Database (example for local Postgres)
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

The repository includes a `compose.yaml` that defines a Postgres service. The Compose file sets the following example environment variables:

- POSTGRES_DB=mydatabase
- POSTGRES_USER=myuser
- POSTGRES_PASSWORD=secret

Adjust these values to match your local setup or production secrets management.

## Usage
Start PostgreSQL with Docker Compose (optional, useful for local development):

```bash
docker compose -f compose.yaml up -d
```

Run the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

By default the API runs on http://localhost:8080 (unless overridden in properties).

## API Endpoints (examples)
The project implements CRUD operations for public servants, units and lotações. Replace these examples below with the actual endpoints if they differ in your codebase.

- Servidores
  - GET /api/servidores
  - GET /api/servidores/{id}
  - POST /api/servidores
    - Body: {"nome": "Fulano", "tipo": "EFETIVO", "cpf": "000.000.000-00", ...}
  - PUT /api/servidores/{id}
  - DELETE /api/servidores/{id}

- Unidades
  - GET /api/unidades
  - GET /api/unidades/{id}
  - POST /api/unidades
  - PUT /api/unidades/{id}
  - DELETE /api/unidades/{id}

- Lotações
  - GET /api/lotacoes
  - GET /api/lotacoes/{id}
  - POST /api/lotacoes
  - PUT /api/lotacoes/{id}
  - DELETE /api/lotacoes/{id}

If your controllers expose different paths or additional endpoints, update this section with the real paths and example request/response payloads.

## Database
This project uses PostgreSQL (see `compose.yaml`). For quick local development you can use the provided Docker Compose service. In production, point `spring.datasource.url` to your managed database and configure credentials securely using environment variables or your secrets manager.

## Contributing
Contributions are welcome! If you find issues or have suggestions:

1. Fork the repository.
2. Create a branch for your change: `git checkout -b feat/your-feature`.
3. Commit your changes with clear messages and follow the existing code style.
4. Open a Pull Request describing the change and the rationale.

Please run tests (if added) and ensure the project builds before submitting a PR.

---

If you'd like, I can also:
- generate a sample Postman collection for the example endpoints,
- scan the codebase for controllers and update the API Endpoints section to reflect the actual routes,
- or add a CONTRIBUTING.md and a basic GitHub Actions workflow to run `./mvnw test` on PRs. Let me know which you'd prefer.
