package dev.tuhkanens.crossplatformlib.api

import dev.tuhkanens.crossplatformlib.enums.PlatformType

interface PlatformTypeAPI {
    fun getType(): PlatformType
    fun isType(type: PlatformType): Boolean
}