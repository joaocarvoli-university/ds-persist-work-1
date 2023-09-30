import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}