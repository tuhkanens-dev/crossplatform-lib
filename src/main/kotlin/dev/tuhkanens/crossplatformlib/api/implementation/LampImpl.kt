package dev.tuhkanens.crossplatformlib.api.implementation

import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.loader.LampLoader
import revxrsal.commands.command.ExecutableCommand

internal class LampImpl : LampAPI {

    private lateinit var loader: LampLoader<*>

    override fun getLoader(): LampLoader<*>? {
        return if (hasLoader()) loader else null
    }

    override fun setLoader(loader: LampLoader<*>) {
        this.loader = loader
    }

    override fun hasLoader(): Boolean {
        return ::loader.isInitialized
    }

    override fun registerCommands(instances: ExecutableCommand<*>) = with (loader) {
        if (!hasLoader()) return@with
        lamp.register(instances)
        applyLampVisitors()
        applyBuilderVisitors()
    }

}