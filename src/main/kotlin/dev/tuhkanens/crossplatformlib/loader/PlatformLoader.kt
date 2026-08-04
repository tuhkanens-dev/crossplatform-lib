package dev.tuhkanens.crossplatformlib.loader

import org.slf4j.Logger
import java.nio.file.Path

abstract class PlatformLoader {

    abstract fun getLogger(): Logger
    abstract fun getDirectory(): Path

}