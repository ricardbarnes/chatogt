group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version ("2.0.21")
    kotlin("plugin.spring") version ("2.0.21")
    id("org.springframework.boot") version ("3.1.1")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}