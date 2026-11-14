# 0001 — Use layered architecture

- **Status:** Accepted
- **Date:** 2026-11-14

## Context

The project is intended to practice maintainable backend design, not only
framework configuration. HTTP concerns, business rules, and persistence should
remain replaceable and easy to test independently.

## Decision

Use a small layered design: web controllers translate HTTP requests, services
coordinate use cases and business rules, and repositories abstract storage.

## Consequences

This introduces a few interfaces and mapping types, but makes unit tests
focused and allows the in-memory repository to be replaced later.
