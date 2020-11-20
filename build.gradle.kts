import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
	kotlin("plugin.jpa") version "1.4.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	mavenLocal()
	jcenter()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://dl.bintray.com/konrad-kaminski/maven") }

}

dependencies {
	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// kotlin coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.9")

	// spring boot
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.kotlin:spring-kotlin-coroutine:0.3.7")

	// spring boot reactor
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")

	// spring boot jpa
	// implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// mysql
	implementation("mysql:mysql-connector-java")

	// swagger
	implementation("org.springdoc:springdoc-openapi-webflux-ui:1.4.8")

	// jackson kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// log
	implementation("org.slf4j:slf4j-api:1.7.30")
	implementation("org.apache.logging.log4j:log4j-core:2.13.3")
	implementation("org.apache.logging.log4j:log4j-api:2.13.3")
	implementation("io.github.microutils:kotlin-logging:1.7.10")


	implementation("org.apache.commons:commons-lang3:3.10")
	implementation("commons-codec:commons-codec:1.14")

	implementation(platform("io.ktor:ktor-bom:1.3.0"))
	implementation("io.ktor:ktor-server-core")
	implementation("io.ktor:ktor-server-netty")
	implementation("io.ktor:ktor-client-core")
	implementation("io.ktor:ktor-client-cio")
	implementation("io.ktor:ktor-client-jackson")
	implementation("io.ktor:ktor-client-logging-jvm")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
