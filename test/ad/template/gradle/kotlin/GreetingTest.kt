package ad.template.gradle.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals

class GreetingTest {

    @Test
    fun `casual greeting starts with hello`() =
        assert(
            CasualGreeting().asString().startsWith("Hello")
        )

    @Test
    fun `casual greeting ends with a bang!`() =
        assert(
            CasualGreeting().asString().endsWith("!")
        )

    @ParameterizedTest
    @ValueSource(
        strings = [
            "Alice",
            "Bob",
            "Eve"
        ]
    )
    fun `casual greeting greets person by name`(name: String) =
        assertEquals(
            expected = "Hello, $name!",
            CasualGreeting(name).asString()
        )

    @Test
    fun `casual greeting is Hello! when no name is given`() =
        assertEquals(
            expected = "Hello!",
            CasualGreeting().asString()
        )

    @Test
    fun `hello world greets the world casually`() =
        assertEquals(
            expected = "Hello, world!",
            HelloWorld.asString()
        )
}
