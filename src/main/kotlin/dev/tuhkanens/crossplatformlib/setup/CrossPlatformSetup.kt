package dev.tuhkanens.crossplatformlib.setup

import dev.tuhkanens.crossplatformlib.CrossAPI
import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.api.SchedulerAPI
import dev.tuhkanens.crossplatformlib.bootstrap.LampBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.LibraryBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.PlatformBootstrap
import dev.tuhkanens.crossplatformlib.bootstrap.SchedulerBootstrap

class CrossPlatformSetup {

    fun setPlatform(bootstrap: PlatformBootstrap) {
        CrossAPI.register<PlatformAPI>(bootstrap)
    }

    fun setScheduler(bootstrap: SchedulerBootstrap) {
        CrossAPI.register<SchedulerAPI>(bootstrap)
    }

    fun setLamp(bootstrap: LampBootstrap<*>) {
        CrossAPI.get<LampAPI>().setBootstrap(bootstrap)
    }

    fun setLibraries(bootstrap: LibraryBootstrap) {
        bootstrap.load()
        CrossAPI.get<LibraryAPI>().apply {
            setPlatformLibraries(bootstrap.manager, bootstrap.libraries)
            loadLibraries()
        }
    }

}