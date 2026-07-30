package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.api.LibrariesAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LibrariesImpl

object CrossPlatform {

    fun onLoad() {
        CrossPlatformAPI.registerAPI<LibrariesAPI>(LibrariesImpl())
    }

}