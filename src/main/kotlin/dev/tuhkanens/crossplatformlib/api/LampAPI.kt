package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.bootstrap.LampBootstrap

interface LampAPI {
    fun setBootstrap(bootstrap: LampBootstrap<*>)
    fun getBootstrap(): LampBootstrap<*>?
    fun hasBootstrap(): Boolean
    fun registerCommands(vararg instances: Any)
}