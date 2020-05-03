package ad.template.gradle.kts.simple

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

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
    fun `hello world uses casual greeting`() {
        assertThat(
            HelloWorld.asString()
        ).isEqualTo(
            "Hello, world!"
        )
    }
}