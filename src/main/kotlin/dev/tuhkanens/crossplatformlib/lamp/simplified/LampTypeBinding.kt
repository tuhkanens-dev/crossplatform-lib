package dev.tuhkanens.crossplatformlib.lamp.simplified

import revxrsal.commands.Lamp
import revxrsal.commands.autocomplete.SuggestionProvider
import revxrsal.commands.command.CommandActor
import revxrsal.commands.parameter.ParameterType

class CrossLampTypeBinding<A : CommandActor, T : Any>(
    val targetClass: Class<T>,
    val parameterType: ParameterType<A, T>,
    val suggestionProvider: SuggestionProvider<A>? = null
)

fun <A : CommandActor, T : Any> Lamp.Builder<A>.registerBinding(
    binding: CrossLampTypeBinding<A, T>
) = apply {
    parameterTypes { types ->
        types.addParameterType(binding.targetClass, binding.parameterType)
    }
    binding.suggestionProvider?.let { provider ->
        suggestionProviders { providers ->
            providers.addProvider(binding.targetClass, provider)
        }
    }
}