package dev.tuhkanens.crossplatformlib.api.implementation

import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.bootstrap.LampBootstrap

internal class LampImpl : LampAPI {

    private lateinit var loader: LampBootstrap<*>

    override fun getLoader(): LampBootstrap<*>? {
        return if (hasLoader()) bootstrap else null
    }

    override fun setLoader(loader: LampBootstrap<*>) {
        this.bootstrap = bootstrap
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