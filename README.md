# Smart Clinic Management System

This workspace contains the Smart Clinic Management System capstone scaffold.

## Current status

- Spring Boot backend scaffolded and compiling
- Static frontend pages added for role-specific screenshots
- MySQL and MongoDB design docs added
- Docker and CI files added
- Submission checklist and verification commands added

## Modules

- Module 1: requirements and architecture
- Module 2: database design and models
- Module 3: sample data and stored procedures
- Module 4: frontend and MVC
- Module 5: containerization and deployment
- Module 6: final submission links

## Run locally

1. Start the backend from `backend/` with `mvn spring-boot:run`.
2. If port 8080 is occupied, run `java -jar target/backend-0.0.1-SNAPSHOT.jar --server.port=8081`.
3. Serve `frontend/` with `python -m http.server 3000 --directory frontend` from the repo root.

## Submission help

- Use `docs/final-submission-checklist.md` for the exact file list.
- Use `docs/verification-commands.md` for SQL and curl command examples.
- Create the public GitHub issue link from the user stories in `docs/issues.md`.