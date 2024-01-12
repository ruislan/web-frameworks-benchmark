plugins {
    id("java")
}

group = "com.ruislan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.activej:activej-launchers-http:6.0-beta2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("ch.qos.logback:logback-classic:1.3.4")
}

tasks.test {
    useJUnitPlatform()
}