import com.google.protobuf.gradle.id

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.google.protobuf") version "0.9.4"
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
    implementation(project(":shared:infrastructure"))
    implementation(project(":chat:domain:core"))
    implementation(project(":chat:domain:application"))
    implementation("org.springframework.boot:spring-boot-starter:3.4.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.kafka:spring-kafka:3.3.4")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.4")
    implementation("org.springframework.security:spring-security-core:6.4.5")
    implementation("org.springframework.security:spring-security-web:6.4.5")
    implementation("org.springframework.security:spring-security-config:6.4.5")
    implementation("io.grpc:grpc-netty-shaded:1.72.0")
    implementation("io.grpc:grpc-protobuf:1.72.0")
    implementation("io.grpc:grpc-stub:1.72.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.3")
    implementation("com.google.protobuf:protobuf-java:4.28.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("net.devh:grpc-server-spring-boot-starter:3.1.0.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // TODO: investigate why this is needed

    from(sourceSets.main.get().resources.srcDirs) {
        exclude("**/*.proto")
    }
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

sourceSets {
    main {
        proto {
            srcDir("src/main/proto")
        }
        resources {
            exclude("**/*.proto")
        }
    }

}