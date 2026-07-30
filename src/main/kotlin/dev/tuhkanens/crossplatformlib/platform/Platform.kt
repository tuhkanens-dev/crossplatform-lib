package dev.tuhkanens.crossplatformlib.platform

interface Platform {

    fun setup(block: PlatformLoader.() -> Unit) {
        val platform = PlatformLoader()
        platform.block()
    }

}