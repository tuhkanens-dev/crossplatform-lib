package dev.tuhkanens.crossplatformlib.api.implementation

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.Libraries

class LibrariesImpl : Libraries {

    private lateinit var manager: LibraryManager
    private var libraries: List<Library> = emptyList()

    override fun setLibraries(manager: LibraryManager, libraries: List<Library>) {
        this.manager = manager
        this.libraries = libraries
    }

    override fun getLibraries(): List<Library> {
        return libraries
    }

    override fun loadLibraries() {
        val standardLibraries = CrossPlatformAPI.getAPI<StandardLibrariesImpl>().getLibraries()
        manager.loadLibraries(*standardLibraries.toTypedArray(), *libraries.toTypedArray())
    }

}