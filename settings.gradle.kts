pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include("common")

include("1.18.2-common")
include("1.18.2-forge")

include("1.19.2-common")
include("1.19.2-forge")

include("1.20.1-common")
include("1.20.1-forge")
include("1.20.1-fabric")

include("1.21.1-common")
include("1.21.1-fabric")
include("1.21.1-neo")

include("26.1-common")
include("26.1-fabric")
include("26.1-neo")

include("26.2-common")
include("26.2-fabric")
include("26.2-neo")

val ciBuildProjectNames = rootProject.children
    .map { it.name }
    .filterNot { it == "common" || it.endsWith("-common") }

gradle.extensions.extraProperties["ciBuildProjectNames"] = ciBuildProjectNames
