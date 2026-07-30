package dev.tuhkanens.crossplatformlib.controller

import com.alessiodp.libby.Library

object StandardLibraries {

    private var libraries: List<Library> = emptyList()

    fun setLibraries(libraries: List<Library>) {
        this.libraries = libraries
    }

    fun getLibraries(): List<Library> {
        return libraries
    }

}