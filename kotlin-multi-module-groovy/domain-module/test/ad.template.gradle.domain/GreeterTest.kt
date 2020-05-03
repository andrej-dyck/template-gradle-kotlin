package ad.template.gradle.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*

@DisplayName("Greeter")
class GreeterTest {
    
    private val greeter = EnglishGreeter()
    
    @Test
    fun `must greet the world!`() {
        val greeting = greeter.greet(WORLD)
        
        greeting.must.startWith("Hello, $WORLD!")
    }
    
    @Test
    fun `must greet everyone!`() {
        val greetings = greeter.greetAll(listOf("Alice", "Bob", "Charlie"))
        
        greetings.must.containExactly(
            "Hello, Alice! :D",
            "Hello, Bob! :D",
            "Hello, Charlie! :D"
        )
    }
}

private fun CustomAssert<String>.startWith(exceptedPrefix: String) = custom {
    assertThat(it).startsWith(exceptedPrefix);
}

private fun <T> CustomAssert<List<T>>.containExactly(vararg exceptedElements: T) = custom {
    assertThat(it).containsExactly(*exceptedElements)
}

private const val WORLD = "world"