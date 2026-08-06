package dev.tuhkanens.crossplatformlib.api.implementation

import dev.tuhkanens.crossplatformlib.api.PlatformTypeAPI
import dev.tuhkanens.crossplatformlib.enums.PlatformType

class PlatformTypeImpl : PlatformTypeAPI {

    private val currentType: PlatformType by lazy { detectPlatform() }

    override fun getType(): PlatformType {
        return currentType
    }

    override fun isType(type: PlatformType): Boolean {
        val current = getType()
        return current == type
    }

    private fun detectPlatform(): PlatformType {
        return when {
            hasClass("io.papermc.paper.threadedregions.RegionizedServer") -> PlatformType.FOLIA
            hasClass("com.velocitypowered.api.proxy.ProxyServer") -> PlatformType.VELOCITY
            hasClass("net.fabricmc.loader.api.FabricLoader") -> PlatformType.FABRIC
            hasClass("org.spongepowered.api.Sponge") -> PlatformType.SPONGE
            hasClass("com.destroystokyo.paper.PaperConfig") || hasClass("io.papermc.paper.configuration.PaperConfigurations") -> PlatformType.PAPER
            hasClass("org.spigotmc.SpigotConfig") -> PlatformType.SPIGOT
            else -> PlatformType.UNKNOWN
        }
    }

    private fun hasClass(className: String): Boolean {
        return try {
            Class.forName(className)
            true
        } catch (_: ClassNotFoundException) {
            false
        }
    }

}