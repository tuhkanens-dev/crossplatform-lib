package dev.tuhkanens.crossplatformlib

import dev.tuhkanens.crossplatformlib.api.Libraries
import dev.tuhkanens.crossplatformlib.api.StandardLibraries
import dev.tuhkanens.crossplatformlib.api.implementation.LibrariesImpl
import dev.tuhkanens.crossplatformlib.api.implementation.StandardLibrariesImpl

object CrossPlatform {

    fun onLoad() {
        CrossPlatformAPI.registerAPI<StandardLibraries>(StandardLibrariesImpl())
        CrossPlatformAPI.registerAPI<Libraries>(LibrariesImpl())
    }

}