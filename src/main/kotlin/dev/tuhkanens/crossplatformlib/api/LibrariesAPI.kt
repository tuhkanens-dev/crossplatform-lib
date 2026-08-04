package dev.tuhkanens.crossplatformlib.api

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager

interface LibrariesAPI {
    fun setCustomLibraries(manager: LibraryManager, libraries: List<Library>)
    fun getCustomLibraries(): List<Library>
    fun setStandardLibraries(standardLibraries: List<Library>)
    fun getStandardLibraries(): List<Library>
    fun loadLibraries(standardLibraries: List<Library>)
}