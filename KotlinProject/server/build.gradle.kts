plugins {
    alias(libs.plugins.kotlinJvm)
    application
}

application {
    mainClass.set("org.example.project.server.ApplicationKt")
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.12")
    implementation("io.ktor:ktor-server-netty:2.3.12")
    implementation("com.mysql:mysql-connector-j:9.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}
