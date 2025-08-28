plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.dio"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.liquibase:liquibase-core:4.29.1")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("org.projectlombok:lombok:1.18.34")

	annotationProcessor("org.projectlombok:lombk:1.18.34")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
