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

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":shared:infrastructure"))
    implementation(project(":chats:domain:core"))
    implementation(project(":chats:domain:application"))

    implementation("org.springframework.boot:spring-boot-starter:3.4.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.kafka:spring-kafka:3.3.4")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.4")
    implementation("org.springframework.security:spring-security-core:6.4.5")
    implementation("org.springframework.security:spring-security-web:6.4.5")
    implementation("org.springframework.security:spring-security-config:6.4.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
}