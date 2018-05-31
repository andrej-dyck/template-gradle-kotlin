package ad.template.gradle.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*

@DisplayName("Greeter")
class GreeterTest {
    
    @Test
    fun `must greet the world!`() {
        // given
        val greeter = EnglishGreeter()
        
        // when
        val greeting = greeter.greet(WORLD)
        
        // then
        assertThat(greeting).isEqualTo("Hello, $WORLD!")
    }
}

private const val WORLD = "world"