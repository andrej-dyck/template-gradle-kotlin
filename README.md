# Gradle Kotlin Project Template

![alt text](gradle-kotlin-logo.jpeg "Gradle Kotlin")

Engineering a good Gradle structure for Kotlin projects.

## Changes

#### 2.1.x

* Update Gradle to 5.3
* Update Kotlin to 1.3.21
* Update Junit to 5.4.1
* Remove Junit-Vintage
* Update AssertJ to 3.12.2
* Update Jqwik to 1.1.1

#### 2.0.0

* Update Gradle to 5.0
* Update Kotlin to 1.3.11
* Update Junit to 5.3.2
* Update Jqwik to 0.9.3

#### 1.4.0

* Update Gradle to 4.10.1
* Update Kotlin to 1.2.50
* Update Junit to 5.3.1
* Update AssertJ to 3.11.1
* Update Log4J2 to 2.11.1
* Remove Mockito

#### 1.3.x

* Update Gradle to 4.8.1
* Use new wrapper task syntax
* Define wrapper type as *BIN* 
* Amend publishing task to be compatible with Gradle 5.0
* Update Kotlin to 1.2.50
* Update Mockito to 2.19.0

#### 1.2.x

* Update Gradle to 4.7

#### 1.1.x

* Multi-project Gradle build ([build.gradle], [settings.gradle]) with Gradle wrapper
* Sub-projects have custom name for their build files  
* Dependencies (*repositories*, *versions*, *uris*) are in a single file ([gradle/dependencies.gradle])
* *Kotlin* is defined for all sub-projects ([gradle/kotlin.gradle])
* *JUnit5* and *AssertJ* are defined for all sub-projects ([gradle/junit+assertj.gradle])
* *Java* and *Maven-publish* are included as templates ([gradle/java.gradle], [gradle/publish-to-nexus.gradle])
* Clean-up for IntelliJ's *out/* folders ([gradle/clean-up.gradle])
* Example Kotlin sub-projects ([domain-module/domain-module.gradle], [details-module/details-module.gradle], [main/main.gradle])
  * Sub-projects have sources, resources, test, and test-resources pre-defined as per Kotlin convention 
  * [details-module/details-module.gradle] depicts how to use dependencies from [gradle/dependencies.gradle] or alternatively predefined as single gradle file (e.g., [gradle/log4j.gradle])
  * [main/main.gradle] depicts how to define *main class*, *executable jar*, and template for *publishing distZip*

[build.gradle]: build.gradle
[settings.gradle]: settings.gradle
[gradle/dependencies.gradle]: gradle/dependencies.gradle
[gradle/clean-up.gradle]: gradle/clean-up.gradle
[gradle/kotlin.gradle]: gradle/kotlin.gradle
[gradle/junit+assertj.gradle]: gradle/junit+assertj.gradle
[gradle/java.gradle]: gradle/java.gradle
[gradle/publish-to-nexus.gradle]: gradle/publish-to-nexus.gradle 
[gradle/log4j.gradle]: gradle/log4j.gradle
[domain-module/domain-module.gradle]: domain-module/domain-module.gradle
[details-module/details-module.gradle]: details-module/details-module.gradle}
[main/main.gradle]: main/main.gradle