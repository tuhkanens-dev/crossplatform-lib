package dev.tuhkanens.crossplatformlib.platform

class PlatformSetup {

    fun execute(block: () -> Unit) {
        block()
    }

}