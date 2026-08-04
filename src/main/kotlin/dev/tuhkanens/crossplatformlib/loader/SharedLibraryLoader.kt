package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI

abstract class SharedLibraryLoader {

    abstract val standardLibraries: List<Library>

    open fun setLibraries(libraries: List<Library>) {
        CrossPlatformAPI.getAPI<LibrariesAPI>().setStandardLibraries(libraries)
    }
    open fun getLibraries(): List<Library> = standardLibraries

}