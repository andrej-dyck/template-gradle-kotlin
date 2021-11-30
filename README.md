# Gradle Kotlin Project Template

![alt text](gradle-kotlin-logo.jpeg "Gradle Kotlin")

A simple Gradle template for Kotlin projects. E.g., to jump start a coding kata.

Instead of forking this repository, simply create a repository with the `"Use this template"` button. This will also trigger a clean-up action.

## Dependencies
* [Kotlin (JVM)](https://kotlinlang.org/docs/home.html)
* [Detekt](https://detekt.github.io/detekt/)
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [AssertJ](https://assertj.github.io/doc/)
* [Jqwik](https://jqwik.net/)

## Build with Gradle
```
./gradlew build
```

#### Only Assemble
```
./gradlew assemble
```
#### Only Detekt
```
./gradlew detekt
```
#### Only Tests
```
./gradlew test
```