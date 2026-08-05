package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibraryAPI

abstract class SharedLibraryLoader {

    abstract val standardLibraries: List<Library>

    fun setLibraries(libraries: List<Library>) {
        CrossPlatformAPI.getAPI<LibraryAPI>().setStandardLibraries(libraries)
    }

}