package dev.tuhkanens.crossplatformlib.bootstrap

import com.alessiodp.libby.Library
import dev.tuhkanens.crossplatformlib.CrossAPI
import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.PlatformTypeAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LampImpl
import dev.tuhkanens.crossplatformlib.api.implementation.LibraryImpl
import dev.tuhkanens.crossplatformlib.api.implementation.PlatformTypeImpl

abstract class SharedBootstrap {

    open fun sharedLibraries(): List<Library> = emptyList()

    open fun onLoad() {
        CrossAPI.apply {
            registerAPI<LibraryAPI>(LibraryImpl())
            registerAPI<LampAPI>(LampImpl())
            registerAPI<PlatformTypeAPI>(PlatformTypeImpl())
        }

        val libraries = sharedLibraries()
        if (libraries.isNotEmpty()) {
            CrossAPI.getAPI<LibraryAPI>().setStandardLibraries(libraries)
        }
    }

    abstract fun onEnable()
    abstract fun onDisable()

}