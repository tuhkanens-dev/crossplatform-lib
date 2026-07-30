package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.CrossPlatformAPI
import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import org.slf4j.Logger
import java.nio.file.Path

abstract class PlatformLoader {

    abstract fun getLogger(): Logger
    abstract fun getDirectory(): Path

    init {
        CrossPlatformAPI.registerAPI<PlatformAPI>(this)
    }

}