# Backend Learning Roadmap

This project is a continuous BookShelf backend. Each task should be completed
in its own pull request and should increase the difficulty without introducing
unnecessary complexity too early.

## How to use this roadmap

For every task:

1. Read the context and acceptance criteria.
2. Design the boundaries before implementing.
3. Write unit tests for business rules first.
4. Implement the smallest solution that passes the tests.
5. Add HTTP or integration tests where the task requires them.
6. Record important design decisions in `docs/decisions/`.
7. Write a short review note: what was difficult, what changed, and what you
   would improve next.

Do not skip ahead because a later task looks more interesting. The difficulty
comes from making each small feature reliable and well-tested.

## Stage 1 — Fundamentals

### Task 01 — In-memory Books API

Build the first Books API with controller, service, repository, DTOs, input
validation, and unit/controller tests.

**Skills:** Spring MVC, constructor injection, REST design, Kotlin modeling,
JUnit, MockMvc.

### Task 02 — Consistent errors

Add global exception handling, validation error responses, malformed UUID
handling, and a Problem Details response format.

**Skills:** exception boundaries, API contracts, error design.

### Task 03 — Filtering and pagination

Add status filtering, sorting, pagination, and response metadata without
leaking collection implementation details into the controller.

**Skills:** query parameters, pagination contracts, API evolution.

## Stage 2 — Persistence and transactions

### Task 04 — PostgreSQL persistence

Replace the in-memory repository with PostgreSQL and Flyway migrations. Keep
the service independent from the database implementation.

**Skills:** Spring Data, SQL, migrations, integration tests, Testcontainers.

### Task 05 — Transactional use cases

Add a reading-session use case that updates a book and records an event in one
transaction. Test rollback behavior.

**Skills:** transaction boundaries, consistency, persistence modeling.

### Task 06 — Database constraints and optimistic locking

Prevent invalid duplicate data at both the application and database layers.
Handle concurrent updates with optimistic locking.

**Skills:** constraints, race conditions, conflict responses.

## Stage 3 — Security and user features

### Task 07 — Users and ownership

Introduce users. A user can only view and modify their own books.

**Skills:** relationships, authorization rules, ownership queries.

### Task 08 — Authentication and roles

Add login, password hashing, token authentication, and roles for normal users
and administrators.

**Skills:** Spring Security, authentication versus authorization, secure errors.

### Task 09 — Rate limiting and abuse protection

Protect expensive or sensitive endpoints and return useful rate-limit headers.

**Skills:** filters, quotas, security boundaries, failure behavior.

## Stage 4 — Asynchronous workflows

### Task 10 — Notifications

When a user marks a book as read, publish a domain event and process a fake
notification asynchronously.

**Skills:** domain events, application events, async processing, retries.

### Task 11 — Reliable event publishing

Replace direct event publishing with an outbox table and a worker that retries
failed deliveries safely.

**Skills:** outbox pattern, at-least-once delivery, idempotency.

### Task 12 — Background imports

Import books from a supplied file or fake external provider with job status,
progress, cancellation, and retry behavior.

**Skills:** job state machines, scheduling, async APIs, external boundaries.

## Stage 5 — Production readiness

### Task 13 — Observability

Add structured logs, correlation IDs, metrics, tracing boundaries, and health
checks without logging secrets or personal data.

**Skills:** Actuator, operational signals, diagnostics.

### Task 14 — Resilience around external services

Integrate a fake book metadata provider with timeouts, retries, circuit
breaking, fallback behavior, and a clear failure contract.

**Skills:** resilience patterns, timeout design, dependency isolation.

### Task 15 — Performance and caching

Measure a slow query, add a cache with an invalidation strategy, and prove the
improvement with a repeatable test or benchmark.

**Skills:** profiling, cache consistency, performance measurement.

## Stage 6 — Advanced system design

### Task 16 — Search read model

Create a separate search-oriented read model updated from domain events.
Document eventual consistency and rebuild behavior.

**Skills:** CQRS concepts, projections, eventual consistency.

### Task 17 — Multi-instance correctness

Run multiple application instances and make scheduled work, idempotency, and
distributed locks safe across instances.

**Skills:** distributed coordination, duplicate work, failure recovery.

### Task 18 — Production deployment

Containerize the service, add environment-specific configuration, run it in a
deployment environment, and document rollback and migration procedures.

**Skills:** containers, deployment, configuration, operational ownership.

## Definition of done for every task

- Requirements and assumptions are documented.
- Business rules have focused unit tests.
- External boundaries have appropriate integration or contract tests.
- Error behavior is intentional and documented.
- CI is green.
- The implementation does not solve future tasks prematurely.
- The pull request explains tradeoffs and limitations.

## Current next step

**Task 01 — In-memory Books API** is the next implementation task.
