package dev.tuhkanens.crossplatformlib.lamp.suggester

import java.util.UUID

data class PlayerArgument(
    val name: String,
    val uniqueId: UUID,
    val isOnline: Boolean = false
)