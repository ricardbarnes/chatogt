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

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(project(":shared:infrastructure"))
    implementation(project(":users:domain:core"))
    implementation("org.springframework.boot:spring-boot-starter:3.4.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.kafka:spring-kafka:3.3.4")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.4.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
}