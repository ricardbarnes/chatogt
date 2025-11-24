plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("com.google.protobuf:protobuf-java:4.28.2")
    api("io.grpc:grpc-kotlin-stub:1.4.3")
    api("io.grpc:grpc-stub:1.45.1")
    api("io.grpc:grpc-protobuf:1.45.1")
}

tasks.test {
    useJUnitPlatform()
}
