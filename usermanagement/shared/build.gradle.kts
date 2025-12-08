import com.google.protobuf.gradle.id

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.google.protobuf") version "0.9.4"
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
    api("org.springframework.boot:spring-boot-starter-validation:3.4.5")
    api("org.springframework.boot:spring-boot-starter:3.4.5")
    api("org.springframework.kafka:spring-kafka:3.3.5")
    api("com.google.code.gson:gson:2.11.0")
    api("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.5")
    testApi("org.springframework.boot:spring-boot-starter-test:3.4.5")
}

tasks.test {
    useJUnitPlatform()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.3"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.72.0"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.3:jdk8@jar"
        }
    }

    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}
