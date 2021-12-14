import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.0"
	kotlin("plugin.spring") version "1.6.0"
	kotlin("plugin.jpa") version "1.6.0"
}

group = "aldi.aulia.rosyad"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.1")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.1")
	implementation("org.springframework.boot:spring-boot-starter-validation:2.6.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.1")
	runtimeOnly("mysql:mysql-connector-java:8.0.25")
	runtimeOnly("org.postgresql:postgresql:42.3.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.1") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
