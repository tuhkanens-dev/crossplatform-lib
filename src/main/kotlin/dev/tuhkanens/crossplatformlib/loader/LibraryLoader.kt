package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager

abstract class LibraryLoader {

    abstract val manager: LibraryManager
    abstract val libraries: List<Library>
    abstract val repositories: List<String>

    fun load() {
        manager.addMavenCentral()

        for (repository in repositories) {
            manager.addRepository(repository)
        }
    }

}