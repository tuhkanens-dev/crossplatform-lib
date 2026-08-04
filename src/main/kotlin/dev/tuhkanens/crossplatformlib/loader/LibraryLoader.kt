package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import com.alessiodp.libby.Repositories
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI

abstract class LibraryLoader {

    abstract val manager: LibraryManager
    abstract val libraries: List<Library>
    abstract val repositories: List<String>

    init {
        manager.addMavenCentral()

        for (repository in repositories) {
            manager.addRepository(repository)
        }
    }

}