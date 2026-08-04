package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.loader.LibraryLoader
import dev.tuhkanens.crossplatformlib.loader.PlatformLoader

class CrossPlatformSetup {

    fun setPlatform(loader: PlatformLoader) {
        CrossPlatformAPI.registerAPI<PlatformAPI>(loader)
    }

    fun setLibrary(loader: LibraryLoader) {
        CrossPlatformAPI.getAPI<LibrariesAPI>().setCustomLibraries(loader.manager, loader.libraries)
    }

}