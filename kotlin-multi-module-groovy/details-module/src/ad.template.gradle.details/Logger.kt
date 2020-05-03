package ad.template.gradle.details

import org.apache.logging.log4j.*

interface Logger {
    
    fun debug(msg: String)
    fun info(msg: String)
    fun info(msg: String, arg: Any)
    fun warn(msg: String)
    fun error(msg: String)
}

class Log4j2Adapter(name: String) : Logger {
    
    private val log4jLogger by lazy { LogManager.getLogger(name) }
    
    override fun debug(msg: String) = log4jLogger.debug(msg)
    override fun info(msg: String) = log4jLogger.info(msg)
    override fun info(msg: String, arg: Any) = log4jLogger.info(msg, arg)
    override fun warn(msg: String) = log4jLogger.warn(msg)
    override fun error(msg: String) = log4jLogger.error(msg)
}