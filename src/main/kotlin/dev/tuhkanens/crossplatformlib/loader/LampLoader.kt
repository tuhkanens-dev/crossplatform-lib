package dev.tuhkanens.crossplatformlib.loader

import revxrsal.commands.Lamp
import revxrsal.commands.LampBuilderVisitor
import revxrsal.commands.LampVisitor
import revxrsal.commands.command.CommandActor

abstract class LampLoader<A : CommandActor> {

    abstract val builder: Lamp.Builder<A>

    open val lampVisitors: List<LampVisitor<A>> = emptyList()
    open val builderVisitors: List<LampBuilderVisitor<A>> = emptyList()

    val lamp: Lamp<A> by lazy { builder.build() }

    fun applyLampVisitors() {
        lampVisitors.forEach(lamp::accept)
    }

    fun applyBuilderVisitors() {
        builderVisitors.forEach(builder::accept)
    }

}