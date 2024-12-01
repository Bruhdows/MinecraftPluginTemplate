plugins {
    id("java")
    id("com.gradleup.shadow") version "9.0.0-beta2"
}

group = "me.bruhdows"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.withType<JavaCompile> {
    options.release = 17
    options.encoding = "UTF-8"
}

tasks.shadowJar {
    archiveFileName.set("${project.name}-${project.version}.jar")
}
