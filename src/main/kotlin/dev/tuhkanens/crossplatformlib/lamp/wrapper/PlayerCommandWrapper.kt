package dev.tuhkanens.crossplatformlib.lamp.wrapper

import java.nio.charset.StandardCharsets
import java.util.UUID

object PlayerCommandWrapper {

    private val consoleUuid: UUID = UUID(0, 0)

    fun isPlayer(uuid: UUID): Boolean {
        return uuid != consoleUuid
    }

    fun getOfflineUUID(playerName: String): UUID {
        return UUID.nameUUIDFromBytes("OfflinePlayer:$playerName".toByteArray(StandardCharsets.UTF_8))
    }

}