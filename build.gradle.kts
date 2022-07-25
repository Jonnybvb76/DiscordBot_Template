plugins {
    java
    application
}

group = "com.name"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-alpha.17")
    implementation("org.slf4j","slf4j-simple","1.7.32")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("com.name.discordbot.DiscordBot")

}

tasks {
    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE

    }

}