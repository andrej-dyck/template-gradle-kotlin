package ad.template.gradle.details

import ad.template.gradle.domain.*

class LoggedGreeter(private val greeter: Greeter, private val logger: Logger) : Greeter {
    
    override fun greet(whom: String): String =
        greeter.greet(whom).also {
            logger.info("Greeted with '{}'", it)
        }
}