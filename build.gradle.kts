import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent


plugins {
	id("org.springframework.boot") version "2.6.8"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.unbroken-dome.test-sets") version "4.0.0"
	id("com.bmuschko.docker-spring-boot-application") version "7.4.0"
	id("com.adarshr.test-logger") version "3.2.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	application
}


group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
	testImplementation("io.rest-assured:kotlin-extensions:5.1.0")
	testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
		exceptionFormat = TestExceptionFormat.SHORT
		showCauses = true
		showExceptions = true
		showStackTraces = true
	}

}


testlogger {
	setTheme("standard")
	showExceptions = true
	showStackTraces =  true
	showFullStackTraces = false
	showCauses=  true
	slowThreshold = 2000
	showSummary = true
	showSimpleNames = false
	showPassed = true
	showSkipped = true
	showFailed = true
	showOnlySlow =  false
	showStandardStreams = false
	showPassedStandardStreams = true
	showSkippedStandardStreams = true
	showFailedStandardStreams = true
	logLevel = LogLevel.LIFECYCLE
}
docker {
	springBootApplication {
		baseImage.set("--platform=linux/amd64 openjdk:17-alpine3.14")
		ports.set(listOf(8080))
		images.set(setOf("kt-fizzbuzz:1.115", "kt-fizzbuzz:latest"))
		jvmArgs.set(listOf("-Dspring.profiles.active=production", "-Xmx2048m"))
	}
}
tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

application {
	mainClass.set("com.example.FizzBuzz.FizzBuzzApplicationKt")
}