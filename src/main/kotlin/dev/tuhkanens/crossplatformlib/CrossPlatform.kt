package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LampImpl
import dev.tuhkanens.crossplatformlib.api.implementation.LibraryImpl
import dev.tuhkanens.crossplatformlib.setup.CrossPlatformSetup

object CrossPlatform {

    fun onLoad() {
        CrossPlatformAPI.apply {
            registerAPI<LibraryAPI>(LibraryImpl())
            registerAPI<LampAPI>(LampImpl())
        }
    }

    fun onSetup(block: CrossPlatformSetup.() -> Unit) {
        val crossPlatform = CrossPlatformSetup()
        crossPlatform.block()
    }

}