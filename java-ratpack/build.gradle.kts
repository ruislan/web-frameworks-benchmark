plugins {
    idea
    id("java")
    id("io.ratpack.ratpack-java") version "2.0.0-rc-1"
}

group = "com.ruislan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.slf4j:slf4j-simple:1.7.36")
}

tasks.test {
    useJUnitPlatform()
}