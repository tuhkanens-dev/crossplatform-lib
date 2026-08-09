package dev.tuhkanens.crossplatformlib.bootstrap

import dev.tuhkanens.crossplatformlib.api.PlatformAPI
import dev.tuhkanens.crossplatformlib.enums.PlatformType
import org.slf4j.Logger
import java.nio.file.Path

abstract class PlatformBootstrap : PlatformAPI {

    abstract override fun getInstance(): Class<*>
    abstract override fun getLogger(): Logger
    abstract override fun getDirectory(): Path

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
            hasClass("net.fabricmc.bootstrap.api.FabricLoader") -> PlatformType.FABRIC
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