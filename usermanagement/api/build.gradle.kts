plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":shared:infrastructure"))
    implementation(project(":usermanagement:shared"))
    implementation(project(":usermanagement:domain:core"))
    implementation(project(":usermanagement:domain:application"))
}
