package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.api.SchedulerAPI
import dev.tuhkanens.crossplatformlib.bootstrap.LibraryBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.PlatformBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.SchedulerBootstrap

class CrossPlatformSetup {

    fun setPlatform(bootstrap: PlatformBootstrap) {
        CrossAPI.registerAPI<PlatformAPI>(bootstrap)
    }

    fun setScheduler(bootstrap: SchedulerBootstrap) {
        CrossAPI.registerAPI<SchedulerAPI>(bootstrap)
    }

    fun setLibraries(bootstrap: LibraryBootstrap) {
        bootstrap.load()
        CrossAPI.getAPI<LibraryAPI>().apply {
            setPlatformLibraries(bootstrap.manager, bootstrap.libraries)
            loadLibraries()
        }
    }

}