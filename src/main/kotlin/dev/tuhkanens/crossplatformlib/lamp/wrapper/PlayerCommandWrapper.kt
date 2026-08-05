package dev.tuhkanens.crossplatformlib.lamp.wrapper

import java.util.UUID

object PlayerCommandWrapper {

    private val consoleUuid: UUID = UUID(0, 0)

    fun isPlayer(uuid: UUID): Boolean {
        return uuid != consoleUuid
    }

}