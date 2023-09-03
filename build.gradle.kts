plugins {
    id("java")
}

allprojects {
    repositories {
        mavenCentral()
    }
    ext["junitVersion"] = "5.10.0"
}

subprojects {
    apply(plugin = "java")

    group = "com.ddoong2"
    version = "1.0.0"

    java.sourceCompatibility = JavaVersion.VERSION_17

    dependencies {
        testImplementation(platform("org.junit:junit-bom:${project.ext["junitVersion"]}"))
        testRuntimeOnly("org.junit.platform:junit-platform-launcher") {
            because("Only needed to run tests in a version of IntelliJ IDEA that bundles older versions")
        }
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.junit.vintage:junit-vintage-engine")
        testImplementation("org.assertj:assertj-core:3.24.2")
        testImplementation("org.mockito:mockito-core:4.8.1")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
