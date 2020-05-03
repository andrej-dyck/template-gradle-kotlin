package ad.gradle.plugin

import org.gradle.kotlin.dsl.DependencyHandlerScope

object Libraries {

    object Versions {
        const val JUnit5 = "5.6.2"
        const val AssertJ = "3.15.0"
    }

    object Test {
        const val Junit5 = "org.junit.jupiter:junit-jupiter:${Versions.JUnit5}"
        const val AssertJ = "org.assertj:assertj-core:${Versions.AssertJ}"
    }
}

fun DependencyHandlerScope.junit5() = "testImplementation"(Libraries.Test.Junit5)
fun DependencyHandlerScope.assertJ() = "testImplementation"(Libraries.Test.AssertJ)