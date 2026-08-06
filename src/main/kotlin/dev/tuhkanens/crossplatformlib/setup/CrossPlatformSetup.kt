package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.api.SchedulerAPI
import dev.tuhkanens.crossplatformlib.bootstrap.LibraryBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.PlatformBoostrap
import dev.tuhkanens.crossplatformlib.bootstrap.SchedulerBoostrap

class CrossPlatformSetup {

    fun setPlatform(loader: PlatformBoostrap) {
        CrossAPI.registerAPI<PlatformAPI>(loader)
    }

    fun setScheduler(loader: SchedulerBoostrap) {
        CrossAPI.registerAPI<SchedulerAPI>(loader)
    }

    fun setLibraries(loader: LibraryBootstrap) {
        loader.load()
        CrossAPI.getAPI<LibraryAPI>().apply {
            setPlatformLibraries(loader.manager, loader.libraries)
            loadLibraries()
        }
    }

}