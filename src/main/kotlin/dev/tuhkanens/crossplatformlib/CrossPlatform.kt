package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.api.LibrariesAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LibrariesImpl
import dev.tuhkanens.crossplatformlib.setup.CrossPlatformSetup

object CrossPlatform {

    fun onLoad() {
        CrossPlatformAPI.registerAPI<LibrariesAPI>(LibrariesImpl())
    }

    fun setup(block: CrossPlatformSetup.() -> Unit) {
        val crossPlatform = CrossPlatformSetup()
        crossPlatform.block()
    }

}