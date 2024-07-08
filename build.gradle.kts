import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.power-assert") version "2.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
}

group = "ad.template.gradle.kotlin"
version = "2.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // kotlin-test
    testImplementation(kotlin("test"))
    // parameterized tests
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.3")
    // AssertJ
    // testImplementation("org.assertj:assertj-core:3.26.0")
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

/* Power-Assert */
@OptIn(ExperimentalKotlinGradlePluginApi::class)
powerAssert {
    functions = listOf(
        "kotlin.assert",
        "kotlin.require",
        "kotlin.test.assert",
        "kotlin.test.assertEquals"
    )
    includedSourceSets = listOf("main", "test")
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
    gradleVersion = "8.8"
    distributionType = Wrapper.DistributionType.BIN
}
