package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.loader.LibraryLoader
import dev.tuhkanens.crossplatformlib.loader.PlatformLoader

class CrossPlatformSetup {

    // For future
    private lateinit var platformLoader: PlatformLoader

    fun setPlatform(loader: PlatformLoader) {
        platformLoader = loader
    }

    fun loadLibraries(loader: LibraryLoader) {
        loader.load()
        CrossPlatformAPI.getAPI<LibrariesAPI>().apply {
            setCustomLibraries(loader.manager, loader.libraries)
            loadLibraries()
        }
    }

}