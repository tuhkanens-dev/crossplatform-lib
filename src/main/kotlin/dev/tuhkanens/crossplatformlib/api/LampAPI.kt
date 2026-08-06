package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.bootstrap.LampBootstrap

interface LampAPI {
    fun setLoader(loader: LampBootstrap<*>)
    fun getLoader(): LampBootstrap<*>?
    fun hasLoader(): Boolean
    fun registerCommands(vararg instances: Any)
}