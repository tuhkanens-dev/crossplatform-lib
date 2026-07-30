package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import dev.tuhkanens.crossplatformlib.controller.StandardLibraries

abstract class LibraryLoader {

    abstract val libraryManager: LibraryManager
    abstract val libraries: List<Library>

    open fun loadLibraries() {
        libraryManager.loadLibraries(*StandardLibraries.getLibraries().toTypedArray(), *libraries.toTypedArray())
    }

}