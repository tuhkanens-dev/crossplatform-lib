plugins {
    kotlin("jvm") version "2.4.0"
}

group = "dev.tuhkanens.crossplatformlib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("net.flectone:libby-core:2.0.0")
}

kotlin {
    jvmToolchain(21)
}