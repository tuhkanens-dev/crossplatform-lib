package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.enums.PlatformType
import org.slf4j.Logger
import java.nio.file.Path

interface PlatformAPI {
    fun getInstance(): Class<*>
    fun getLogger(): Logger
    fun getDirectory(): Path
    fun getType(): PlatformType
    fun isType(type: PlatformType): Boolean
}