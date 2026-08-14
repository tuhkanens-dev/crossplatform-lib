package dev.tuhkanens.crossplatformlib.lamp.suggester

import dev.tuhkanens.crossplatformlib.lamp.simplified.CrossLampTypeBinding
import revxrsal.commands.command.CommandActor
import java.nio.charset.StandardCharsets
import java.util.UUID

fun <A : CommandActor> playerArgumentType(
    players: () -> List<String>,
    uuids: (String) -> UUID = { name ->
        UUID.nameUUIDFromBytes("OfflinePlayer:$name".toByteArray(StandardCharsets.UTF_8))
    },
    isOnline: (String) -> Boolean = { name ->
        players().any { it.equals(name, ignoreCase = true) }
    }
) : CrossLampTypeBinding<A, PlayerArgument> {
    return CrossLampTypeBinding(
        targetClass = PlayerArgument::class.java,
        parameterType = { input, _ ->
            val name = input.readString()
            val online = isOnline(name)
            val uniqueId = uuids(name)

            PlayerArgument(name, uniqueId, online)
        },
        suggestionProvider = PlayerSuggester(players)
    )
}