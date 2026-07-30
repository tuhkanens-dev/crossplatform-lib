package dev.tuhkanens.crossplatformlib.platform

import dev.tuhkanens.crossplatformlib.loader.LibraryLoader

class PlatformLoader {

    fun libraries(loader: LibraryLoader) {
        loader.loadLibraries()
    }

    fun execute(block: () -> Unit) {
        block()
    }

}