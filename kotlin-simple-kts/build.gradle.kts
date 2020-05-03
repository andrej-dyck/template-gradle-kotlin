import ad.gradle.plugin.junit5
import ad.gradle.plugin.assertJ
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"

    /* Packaging JAR */
    id("com.github.johnrengelman.shadow") version "5.1.0"

    /* CLI Application */
    application
}

group = "ad.template.gradle.kts"
version = "1.0"

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    /* Kotlin Coroutines */
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")

    /* JUnit 5 + AssertJ */
    junit5()
    assertJ()
}

/* Compile to JVM 8 */
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        /* Kotlin experimental inline classes */
        // freeCompilerArgs = listOf("-Xinline-classes")
    }
}

/* Check with Junit 5 only */
tasks.named<Test>("test") {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeEngines("junit-vintage")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}

/* Source sets by Kotlin conventions /src and /test */
sourceSets.getByName("main") {
    withConvention(KotlinSourceSet::class) {
        kotlin.srcDirs("src/")
    }
}

sourceSets.getByName("test") {
    withConvention(KotlinSourceSet::class) {
        kotlin.srcDirs("test/")
    }
}

/* CLI Application */
application {
    applicationName = "CliApp"
    mainClassName = "${rootProject.name}.CliAppKt"
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

/* Packaging JAR */
tasks.withType<Jar> {
    archiveClassifier.set("")
    archiveAppendix.set("")
    /* CLI Application */
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}

/* Gradle Wrapper */
tasks.withType<Wrapper> {
    gradleVersion = "6.3"
    distributionType = Wrapper.DistributionType.BIN
}