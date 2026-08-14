package dev.tuhkanens.crossplatformlib.bootstrap

import com.alessiodp.libby.Library
import dev.tuhkanens.crossplatformlib.CrossAPI
import dev.tuhkanens.crossplatformlib.api.LampAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI
import dev.tuhkanens.crossplatformlib.api.implementation.LampImpl
import dev.tuhkanens.crossplatformlib.api.implementation.LibraryImpl

abstract class SharedBootstrap {

    open fun sharedLibraries(): List<Library> = emptyList()

    open fun onLoad() {
        CrossAPI.apply {
            register<LibraryAPI>(LibraryImpl())
            register<LampAPI>(LampImpl())
        }

        val libraries = sharedLibraries()
        if (libraries.isNotEmpty()) {
            CrossAPI.get<LibraryAPI>().setStandardLibraries(libraries)
        }
    }

    abstract fun onEnable()
    abstract fun onDisable()

}