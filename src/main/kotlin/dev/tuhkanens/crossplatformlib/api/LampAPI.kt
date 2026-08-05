package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.loader.LampLoader
import revxrsal.commands.command.ExecutableCommand

interface LampAPI {
    fun setLoader(loader: LampLoader<*>)
    fun getLoader(): LampLoader<*>?
    fun hasLoader(): Boolean
    fun registerCommands(instances: ExecutableCommand<*>)
}