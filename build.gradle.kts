plugins {
	java
	checkstyle
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.codemechanix"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

checkstyle {
	toolVersion = "10.12.3"
	configFile = file("checkstyle.xml")
	isIgnoreFailures = false
	isShowViolations = true
}

tasks.withType<Test> {
	useJUnitPlatform()
}
