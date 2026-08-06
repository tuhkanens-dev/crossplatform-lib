package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.setup.CrossPlatformSetup

object Cross {

    fun onSetup(block: CrossPlatformSetup.() -> Unit) {
        val crossPlatform = CrossPlatformSetup()
        crossPlatform.block()
    }

}