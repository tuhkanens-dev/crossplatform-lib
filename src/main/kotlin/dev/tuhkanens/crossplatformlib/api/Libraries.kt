package dev.tuhkanens.crossplatformlib.api

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager

interface Libraries {
    fun setLibraries(manager: LibraryManager, libraries: List<Library>)
    fun getLibraries(): List<Library>
    fun loadLibraries()
}