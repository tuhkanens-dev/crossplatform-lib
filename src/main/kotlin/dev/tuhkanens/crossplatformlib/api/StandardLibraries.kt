package dev.tuhkanens.crossplatformlib.api

import com.alessiodp.libby.Library

interface StandardLibraries {
    fun setLibraries(libraries: List<Library>)
    fun getLibraries(): List<Library>
}