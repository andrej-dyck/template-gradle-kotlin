package ad.template.gradle.domain

interface Greeter {
    
    fun greet(whom: String): String
}

class EnglishGreeter : Greeter {
    
    override fun greet(whom: String): String  = "Hello, $whom!"
}