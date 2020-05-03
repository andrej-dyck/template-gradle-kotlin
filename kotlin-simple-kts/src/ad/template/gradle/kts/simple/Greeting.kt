package ad.template.gradle.kts.simple

interface Greeting {
    fun asString(): String
}

class CasualGreeting(private val name: String = "") : Greeting {
    override fun asString(): String =
        if (name.isBlank()) "Hello!" else "Hello, $name!"
}

object HelloWorld : Greeting by CasualGreeting("world")