package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import org.slf4j.Logger
import java.nio.file.Path

abstract class PlatformLoader : PlatformAPI {

    abstract override fun getLogger(): Logger
    abstract override fun getDirectory(): Path

}