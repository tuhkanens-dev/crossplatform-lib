package dev.tuhkanens.crossplatformlib.platform

interface Platform {

    fun setup(block: PlatformSetup.() -> Unit) {
        val platform = PlatformSetup()
        platform.block()
    }

}