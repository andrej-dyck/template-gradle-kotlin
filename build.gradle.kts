plugins {
    kotlin("jvm") version "1.8.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

group = "ad.template.gradle.kotlin"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.24.1")
}

/* Source sets by Kotlin conventions /src and /test */
sourceSets.main { kotlin.srcDirs("src/") }
sourceSets.test { kotlin.srcDirs("test/") }

/* Resources */
sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("test-resources")

/* Detekt */
detekt {
    source.setFrom("src/", "test/")
    config.setFrom("detekt.yml")
}

/* Check with JUnit 5 */
tasks.test {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeEngines("junit-vintage")
    }
}

/* Gradle wrapper */
tasks.withType<Wrapper> {
    gradleVersion = "8.3"
    distributionType = Wrapper.DistributionType.BIN
}