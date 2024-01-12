plugins {
    id("java")
}

group = "com.ruislan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val joobyVersion = "3.0.7"

dependencies {
    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("io.jooby:jooby-kotlin:$joobyVersion")
    implementation("io.jooby:jooby-jackson:$joobyVersion")
//    implementation("io.jooby:jooby-undertow:$joobyVersion")
    implementation("io.jooby:jooby-netty:$joobyVersion")
//    implementation("io.jooby:jooby-jetty:$joobyVersion")
}

tasks.test {
    useJUnitPlatform()
}