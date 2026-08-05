package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.api.SchedulerAPI
import dev.tuhkanens.crossplatformlib.loader.LibraryLoader
import dev.tuhkanens.crossplatformlib.loader.PlatformLoader
import dev.tuhkanens.crossplatformlib.loader.SchedulerLoader

class CrossPlatformSetup {

    fun setPlatform(loader: PlatformLoader) {
        CrossPlatformAPI.registerAPI<PlatformAPI>(loader)
    }

    fun setScheduler(loader: SchedulerLoader) {
        CrossPlatformAPI.registerAPI<SchedulerAPI>(loader)
    }

    fun loadLibraries(loader: LibraryLoader) {
        loader.load()

        CrossPlatformAPI.getAPI<LibraryAPI>().apply {
            setPlatformLibraries(loader.manager, loader.libraries)
            loadLibraries()
        }
    }

}