# Spring Cloud Microservices CI/CD

Containerized movie-platform backend built with Spring Boot and Spring Cloud. The project demonstrates service discovery, an API gateway, independent microservices, PostgreSQL persistence, Docker Compose orchestration, and a Jenkins pipeline that builds and publishes service images.

## Architecture

```text
                         +----------------------+
                         |     API Gateway      |
                         |       :8084          |
                         +----------+-----------+
                                    |
                         +----------v-----------+
                         |   Discovery Server   |
                         |       :8761          |
                         +----------+-----------+
                                    |
             +----------------------+----------------------+
             |                      |                      |
       +-----v------+        +------v------+        +------v------+
       | Movie       |        | Movie Info  |        | Ratings Data |
       | Catalog     |        | Service     |        | Service      |
       | :8081       |        | :8082       |        | :8083        |
       +-------------+        +-------------+        +-------------+
```

### Services

| Service | Responsibility | Port |
| --- | --- | --- |
| `api-Gateway` | Routes client requests to backend services | 8084 |
| `discovery-server` | Eureka service registry | 8761 |
| `movie-catalog-service` | Aggregates movie and rating data | 8081 |
| `movie-info-service` | Stores and retrieves movie information | 8082 |
| `ratings-data-service` | Stores and retrieves user ratings | 8083 |

## Prerequisites

- Java 17
- Docker and Docker Compose
- Git
- Jenkins (optional, for the CI/CD pipeline)

## Run locally

1. Copy `.env.example` to `.env` and set local values.
2. Start the complete platform with locally built images:

   ```bash
   docker compose -f docker-compose.yaml up --build
   ```

3. Open the Eureka dashboard at <http://localhost:8761>.
4. Stop the platform:

   ```bash
   docker compose -f docker-compose.yaml down
   ```

To run the previously published Docker Hub images instead, use `run-servers.yaml`.

## Build and test a service

Each service is an independent Maven project:

```bash
cd movie-info-service
./mvnw clean verify
```

On Windows, use `mvnw.cmd clean verify`.

## CI/CD

[`Jenkinsfile`](Jenkinsfile) defines a Jenkins pipeline that:

1. Packages each Spring Boot service.
2. Builds a Docker image for each service.
3. Authenticates to Docker Hub using Jenkins credentials.
4. Publishes the images.

Configure a Jenkins credential with the ID `docker-hub-credentials` before running the pipeline. Credentials are intentionally not stored in this repository.

## Repository structure

```text
.
├── api-Gateway/
├── discovery-server/
├── movie-catalog-service/
├── movie-info-service/
├── ratings-data-service/
├── docker-compose.yaml
├── run-servers.yaml
└── Jenkinsfile
```

## Configuration and security

Database credentials and the movie API key are read from environment variables. The movie information service uses the [TMDB API](https://www.themoviedb.org/documentation/api) to retrieve movie details. Create a TMDB developer API key from your TMDB account and set it as `MOVIE_API_KEY` in your local `.env`, using `.env.example` as a template.
