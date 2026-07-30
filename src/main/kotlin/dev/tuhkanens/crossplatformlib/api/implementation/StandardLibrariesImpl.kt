package dev.tuhkanens.crossplatformlib.api.implementation

import com.alessiodp.libby.Library
import dev.tuhkanens.crossplatformlib.api.StandardLibraries

class StandardLibrariesImpl: StandardLibraries {

    private var libraries: List<Library> = emptyList()

    override fun setLibraries(libraries: List<Library>) {
        this.libraries = libraries
    }

    override fun getLibraries(): List<Library> {
        return libraries
    }

}