package ad.template.gradle.domain

interface Greeter {
    
    fun greet(whom: String): String
    
    fun greetAll(whom: List<String>): List<String> =
        whom.map { greet(it) }
}

class EnglishGreeter : Greeter {
    
    override fun greet(whom: String): String  = "Hello, $whom! :D"
}