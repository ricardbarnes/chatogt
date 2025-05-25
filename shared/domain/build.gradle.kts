plugins {
    kotlin("jvm") version "1.9.25"
    id("java-test-fixtures")
}

group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("io.github.serpro69:kotlin-faker:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}
