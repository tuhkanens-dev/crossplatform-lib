package dev.tuhkanens.crossplatformlib.api

import org.slf4j.Logger
import java.nio.file.Path

interface PlatformAPI {
    fun getLogger(): Logger
    fun getDirectory(): Path
}