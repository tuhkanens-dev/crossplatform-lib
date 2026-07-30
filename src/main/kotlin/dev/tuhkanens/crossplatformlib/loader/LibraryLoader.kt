package dev.tuhkanens.crossplatformlib.loader

import com.alessiodp.libby.Library
import com.alessiodp.libby.LibraryManager
import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.Libraries

abstract class LibraryLoader {

    abstract val manager: LibraryManager
    abstract val libraries: List<Library>

    init {
        CrossPlatformAPI.getAPI<Libraries>().setLibraries(manager, libraries)
        CrossPlatformAPI.getAPI<Libraries>().loadLibraries()
    }

}