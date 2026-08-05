package dev.tuhkanens.crossplatformlib.api

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager

interface LibraryAPI {
    fun hasManager(): Boolean
    fun setPlatformLibraries(manager: LibraryManager, libraries: List<Library>)
    fun getPlatformLibraries(): List<Library>
    fun hasPlatformLibraries(): Boolean
    fun setStandardLibraries(standardLibraries: List<Library>)
    fun getStandardLibraries(): List<Library>
    fun hasStandardLibraries(): Boolean
    fun loadLibraries()
}