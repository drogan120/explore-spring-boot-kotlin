# Agent instructions

## Project overview

This is a Kotlin and Spring Boot practice project. Changes should favor clear
boundaries, small components, explicit domain rules, and tests that describe
observable behavior.

## Before changing code

- Read the relevant task document in `docs/`.
- Inspect existing code and tests before introducing a new pattern.
- Keep each change focused on one task or maintenance concern.

## Implementation rules

- Use constructor injection.
- Keep controllers focused on HTTP translation.
- Keep business rules in application/domain services.
- Do not expose persistence or domain objects directly as API DTOs.
- Prefer immutable Kotlin data and explicit types.
- Do not add dependencies without explaining the need in the pull request.
- Never commit secrets, local configuration, build output, or IDE files.

## Testing rules

- Add or update unit tests for business behavior.
- Add web-slice or integration tests for HTTP behavior.
- Run `./gradlew test` before opening a pull request.
- Do not weaken or delete a test just to make the build pass.

## Change boundaries

Do not implement future tasks unless requested. If requirements are ambiguous,
document the assumption or ask for clarification instead of adding speculative
features.
