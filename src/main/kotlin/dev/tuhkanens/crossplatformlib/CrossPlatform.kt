package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.api.LibrariesAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LibrariesImpl
import dev.tuhkanens.crossplatformlib.loader.PlatformLoader

object CrossPlatform {

    fun onLoad() {
        CrossPlatformAPI.registerAPI<LibrariesAPI>(LibrariesImpl())
    }

    fun setPlatform(loader: PlatformLoader) {
        CrossPlatformAPI.registerAPI<PlatformAPI>(loader)
    }

}