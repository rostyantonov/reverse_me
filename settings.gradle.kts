plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ReverseProject"

include(
    ":common",
    ":java-1",
    ":java-5",
    ":java-6",
    ":java-7",
    ":java-8",
    ":java-9",
    ":java-11",
    ":java-16",
    ":java-17",
    ":java-21"
)
