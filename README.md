# Gradle Kotlin Project Template

![alt text](gradle-kotlin-logo.jpeg "Gradle Kotlin")

![build](https://github.com/andrej-dyck/template-gradle-kotlin/actions/workflows/gradle-ci.yml/badge.svg?branch=main)

A simple Gradle template for Kotlin projects. E.g., to jump start a coding kata.

Instead of forking this repository, simply create a repository with the `"Use this template"` button. This will also trigger a clean-up action.

## Dependencies
* [Kotlin 2.0 (JVM)](https://kotlinlang.org/docs/home.html)
* [Detekt](https://detekt.github.io/detekt/)
* [Kotlin-Test](https://kotlinlang.org/docs/jvm-test-using-junit.html) with [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [Power Assert](https://kotlinlang.org/docs/power-assert.html)


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
