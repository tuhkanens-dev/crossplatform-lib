package dev.tuhkanens.crossplatformlib.lamp.suggester

import revxrsal.commands.autocomplete.SuggestionProvider
import revxrsal.commands.command.CommandActor
import revxrsal.commands.node.ExecutionContext

class PlayerSuggester<A : CommandActor>(
    private val players: () -> List<String>
) : SuggestionProvider<A> {

    override fun getSuggestions(context: ExecutionContext<A>): Collection<String> {
        val input = context.input()
            .source()
            .substringAfterLast(" ")
            .trim()

        return players().filter { it.startsWith(input, ignoreCase = true) }
    }

}