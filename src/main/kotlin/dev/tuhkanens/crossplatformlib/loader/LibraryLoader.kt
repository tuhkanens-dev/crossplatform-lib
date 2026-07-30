package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.LibrariesAPI

abstract class LibraryLoader {

    abstract val manager: LibraryManager
    abstract val libraries: List<Library>

    init {
        CrossPlatformAPI.getAPI<LibrariesAPI>().setCustomLibraries(manager, libraries)
    }

}