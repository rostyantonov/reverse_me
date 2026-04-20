plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ReverseProject"

include(
    ":common",
    ":java-1",
    ":java-5",
    ":java-7",
    ":java-8",
    ":java-11",
    ":java-17",
    ":java-21"
)

project(":java-1").projectDir = file("java/java-1")
project(":java-5").projectDir = file("java/java-5")
project(":java-7").projectDir = file("java/java-7")
project(":java-8").projectDir = file("java/java-8")
project(":java-11").projectDir = file("java/java-11")
project(":java-17").projectDir = file("java/java-17")
project(":java-21").projectDir = file("java/java-21")
