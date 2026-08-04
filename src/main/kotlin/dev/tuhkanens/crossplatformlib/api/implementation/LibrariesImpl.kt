package dev.tuhkanens.crossplatformlib.api.implementation

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import com.alessiodp.libby.Repositories
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI

class LibrariesImpl : LibrariesAPI {

    private lateinit var manager: LibraryManager

    private var customLibraries: List<Library> = emptyList()
    private var standardLibraries: List<Library> = emptyList()

    override fun setCustomLibraries(manager: LibraryManager, libraries: List<Library>) {
        this.manager = manager
        this.customLibraries = libraries
    }

    override fun getCustomLibraries(): List<Library> {
        return customLibraries
    }

    override fun setStandardLibraries(standardLibraries: List<Library>) {
        this.standardLibraries = standardLibraries
    }

    override fun getStandardLibraries(): List<Library> {
        return standardLibraries
    }

    override fun loadLibraries() {
        manager.loadLibraries(*standardLibraries.toTypedArray(), *customLibraries.toTypedArray())
    }

}