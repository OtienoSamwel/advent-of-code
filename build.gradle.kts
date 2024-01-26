
plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "com.otienosamwel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    //coroutines dependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}

tasks.test {
    useJUnit()
}

//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "1.8"
//}

application {
    mainClass.set("MainKt")
}