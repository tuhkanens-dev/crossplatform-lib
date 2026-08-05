package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.loader.LampLoader

interface LampAPI {
    fun setLoader(loader: LampLoader<*>)
    fun getLoader(): LampLoader<*>?
    fun hasLoader(): Boolean
    fun registerCommands(vararg instances: Any)
}