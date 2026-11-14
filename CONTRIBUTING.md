# Contributing

## Development setup

1. Install the JDK version configured in `build.gradle.kts`.
2. Clone the repository.
3. Run `./gradlew test`.
4. Install the optional pre-commit hooks with `pre-commit install`.

## Pull requests

- Use a focused branch and a descriptive commit message.
- Explain the behavior changed and how it was tested.
- Include tests for new behavior and regression cases.
- Keep unrelated refactoring out of feature pull requests.
- Confirm that CI is green before requesting review.

## Commit messages

Use an imperative, descriptive format such as:

```text
feat: add book creation endpoint
fix: reject blank book titles
test: cover unknown book handling
```
