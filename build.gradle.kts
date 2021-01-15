import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.20"
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
}

group = "me.bartosz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
javafx{
    version = "11.0.2"
    modules("javafx.controls", "javafx.graphics")
}
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.20")
    implementation("no.tornado:tornadofx:1.7.20")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.20")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}