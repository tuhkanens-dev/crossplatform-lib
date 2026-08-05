package dev.tuhkanens.crossplatformlib.api.implementation

import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.loader.LampLoader

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

    override fun registerCommands(vararg instances: Any) = with (loader) {
        if (!hasLoader()) return@with
        applyBuilderVisitors()
        lamp.register(*instances)
        applyLampVisitors()
    }

}