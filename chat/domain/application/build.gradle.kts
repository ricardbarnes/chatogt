plugins {
    kotlin("jvm") version "1.9.25"
}

group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":chat:domain:core"))
}
