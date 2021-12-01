package ad.template.gradle.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GreetingTest {

    @Test
    fun `casual greeting starts with hello`() {
        assertThat(
            CasualGreeting().asString()
        ).startsWith(
            "Hello"
        )
    }

    @Test
    fun `casual greeting ends with a bang!`() {
        assertThat(
            CasualGreeting().asString()
        ).endsWith(
            "!"
        )
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "Alice",
            "Bob",
            "Eve"
        ]
    )
    fun `casual greeting greets person by name`(name: String) {
        assertThat(
            CasualGreeting(name).asString()
        ).isEqualTo(
            "Hello, $name!"
        )
    }

    @Test
    fun `casual greeting is Hello! when no name is given`() {
        assertThat(
            CasualGreeting().asString()
        ).isEqualTo(
            "Hello!"
        )
    }

    @Test
    fun `hello world greets the world casually`() {
        assertThat(
            HelloWorld.asString()
        ).isEqualTo(
            "Hello, world!"
        )
    }
}
