package ad.template.gradle.main

import ad.template.gradle.details.*
import ad.template.gradle.domain.*

fun bootstrap(args: Array<String>): () -> Unit {
    val greeter = LoggedGreeter(
        greeter = EnglishGreeter(),
        logger = Log4j2Adapter(EnglishGreeter::javaClass.name)
    )
    val mainLogger = Log4j2Adapter("main")
    
    return {
        mainLogger.info("Start greeting")
        greeter.greetAll(args.toList())
        mainLogger.info("Finished greeting")
    }
}