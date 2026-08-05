package dev.tuhkanens.crossplatformlib.lamp.suggester

import dev.tuhkanens.crossplatformlib.lamp.simplified.CrossLampTypeBinding
import revxrsal.commands.command.CommandActor

fun <A : CommandActor> playerNameArgumentType(
    players: () -> List<String>,
    isOnlineCheck: (String) -> Boolean = { name -> players().any { it.equals(name, ignoreCase = true) } }
) : CrossLampTypeBinding<A, PlayerArgument> {
    return CrossLampTypeBinding(
        targetClass = PlayerArgument::class.java,
        parameterType = { input, _ ->
            val name = input.readString()
            val online = isOnlineCheck(name)

            PlayerArgument(name, online)
        },
        suggestionProvider = PlayerSuggester(players)
    )
}