package dev.tuhkanens.crossplatformlib.bootstrap

import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import org.slf4j.Logger
import java.nio.file.Path

abstract class PlatformBootstrap : PlatformAPI {

    abstract override fun getLogger(): Logger
    abstract override fun getDirectory(): Path

}