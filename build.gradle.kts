plugins {
    kotlin("jvm") version "2.4.0"
    `maven-publish`
}

group = "dev.tuhkanens.crossplatformlib"
version = "2.2.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("net.flectone:libby-core:2.0.0")
    compileOnly("org.slf4j:slf4j-api:2.0.18")
    compileOnly("io.github.revxrsal:lamp.common:4.0.0-rc.17")
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}