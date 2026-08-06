package dev.tuhkanens.crossplatformlib.api.implementation

import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.bootstrap.LampBootstrap

internal class LampImpl : LampAPI {

    private lateinit var bootstrap: LampBootstrap<*>

    override fun getBootstrap(): LampBootstrap<*>? {
        return if (hasBootstrap()) bootstrap else null
    }

    override fun setBootstrap(bootstrap: LampBootstrap<*>) {
        this.bootstrap = bootstrap
    }

    override fun hasBootstrap(): Boolean {
        return ::bootstrap.isInitialized
    }

    override fun registerCommands(vararg instances: Any) = with (bootstrap) {
        if (!hasBootstrap()) return@with
        applyBuilderVisitors()
        lamp.register(*instances)
        applyLampVisitors()
    }

}