package dev.tuhkanens.crossplatformlib.lamp.suggester

import dev.tuhkanens.crossplatformlib.lamp.simplified.CrossLampTypeBinding
import revxrsal.commands.command.CommandActor

fun <A : CommandActor> playerNameArgumentType(
    players: () -> List<String>
) : CrossLampTypeBinding<A, PlayerNameArgument> {
    return CrossLampTypeBinding(
        targetClass = PlayerNameArgument::class.java,
        parameterType = { input, _ ->
            PlayerNameArgument(input.readString())
        },
        suggestionProvider = PlayerNameSuggester(players)
    )
}