plugins {
    kotlin("jvm") version "1.7.0"
    id("io.gitlab.arturbosch.detekt") version "1.20.0"
}

group = "ad.template.gradle.kotlin"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.9.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.23.1")
}

/* Source sets by Kotlin conventions /src and /test */
val sources = setOf("main" to "src/", "test" to "test/")
kotlin {
    sources.forEach { (set, dir) ->
        sourceSets[set].apply { kotlin.srcDirs(dir) }
    }
}

/* Resources */
sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("test-resources")

/* Detekt */
detekt {
    source = files(sources.map { it.second })
    config = files("detekt.yml")
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
    gradleVersion = "7.5.1"
    distributionType = Wrapper.DistributionType.BIN
}