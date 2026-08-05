package dev.tuhkanens.crossplatformlib.api.implementation

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import dev.tuhkanens.crossplatformlib.api.LibraryAPI

internal class LibraryImpl : LibraryAPI {

    private lateinit var manager: LibraryManager

    private var platformLibraries: List<Library> = emptyList()
    private var standardLibraries: List<Library> = emptyList()

    override fun hasManager(): Boolean {
        return ::manager.isInitialized
    }

    override fun setPlatformLibraries(manager: LibraryManager, libraries: List<Library>) {
        this.manager = manager
        this.platformLibraries = libraries
    }

    override fun getPlatformLibraries(): List<Library> {
        return platformLibraries
    }

    override fun hasPlatformLibraries(): Boolean {
        return !platformLibraries.isEmpty()
    }

    override fun setStandardLibraries(standardLibraries: List<Library>) {
        this.standardLibraries = standardLibraries
    }

    override fun getStandardLibraries(): List<Library> {
        return standardLibraries
    }

    override fun hasStandardLibraries(): Boolean {
        return !standardLibraries.isEmpty()
    }

    override fun loadLibraries() {
        if (!hasManager()) return
        manager.loadLibraries(*standardLibraries.toTypedArray(), *platformLibraries.toTypedArray())
    }

}