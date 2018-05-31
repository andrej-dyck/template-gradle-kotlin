package ad.template.gradle.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*

@DisplayName("Greeter")
class GreeterTest {
    
    private val greeter = EnglishGreeter()
    
    @Test
    fun `must greet the world!`() {
        val greeting = greeter.greet(WORLD)
        
        assertThat(greeting).startsWith("Hello, $WORLD!")
    }
    
    @Test
    fun `must greet everyone!`() {
        val greetings = greeter.greetAll(listOf("Alice", "Bob", "Charlie"))
        
        assertThat(greetings).containsExactly(
            "Hello, Alice! :D",
            "Hello, Bob! :D",
            "Hello, Charlie! :D"
        )
    }
}

private const val WORLD = "world"