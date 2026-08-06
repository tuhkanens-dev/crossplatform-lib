package dev.tuhkanens.crossplatformlib.bootstrap

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager

abstract class LibraryBootstrap {

    abstract val manager: LibraryManager
    abstract val libraries: List<Library>

    open val repositories: List<String> = emptyList()

    fun load() {
        manager.addMavenCentral()

        for (repository in repositories) {
            manager.addRepository(repository)
        }
    }

}