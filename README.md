# Spring Boot Kotlin Playground

A continuous practice project for learning Spring Boot and clean backend
engineering with Kotlin.

## Stack

- Kotlin
- Spring Boot
- Spring MVC
- Gradle Kotlin DSL
- JUnit 5

## Requirements

- JDK 25

## Useful commands

```bash
./gradlew test       # run tests
./gradlew check      # run verification checks
./gradlew ktlintCheck
./gradlew detekt
./gradlew jacocoTestReport
./gradlew bootRun    # start the application
```

Install the optional pre-commit hook with:

```bash
pre-commit install
```

## Project conventions

Read [`AGENTS.md`](AGENTS.md) and [`CONTRIBUTING.md`](CONTRIBUTING.md) before
making changes. Exercises and their acceptance criteria live in `docs/`.

## Learning roadmap

1. Project setup and quality automation
2. In-memory Books API
3. Validation and consistent error responses
4. Persistence with a relational database
5. Integration testing and observability
