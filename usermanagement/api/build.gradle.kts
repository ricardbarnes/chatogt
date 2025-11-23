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
    implementation(project(":usermanagement:shared"))
    implementation(project(":usermanagement:domain:core"))
    implementation(project(":usermanagement:domain:application"))
    implementation("org.springframework.boot:spring-boot-starter:3.4.4")
    implementation("org.springframework.kafka:spring-kafka:3.3.4")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.4")
    implementation("io.grpc:grpc-kotlin-stub:1.4.3")
    implementation("com.google.protobuf:protobuf-java:4.28.2")
    implementation("net.devh:grpc-server-spring-boot-starter:2.15.0.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
}