val jooqVersion = "3.19.24"

plugins {
	java
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("nu.studer.jooq") version "9.0"
}

group = "com.agorohov"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(23)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.jooq:jooq:$jooqVersion")
	jooqGenerator("org.jooq:jooq-codegen:$jooqVersion")
	jooqGenerator("org.jooq:jooq-meta:$jooqVersion")
	jooqGenerator("org.postgresql:postgresql:42.7.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

jooq {
	version.set(jooqVersion)
	configurations {
		create("main") {
			jooqConfiguration.apply {
				logging = org.jooq.meta.jaxb.Logging.WARN
				jdbc.apply {
					driver = "org.postgresql.Driver"
					url = "jdbc:postgresql://localhost:5438/meeting-with-jooq?currentSchema=myschema"
					user = "u"
					password = "p"
				}
				generator.apply {
					name = "org.jooq.codegen.DefaultGenerator"
					database.apply {
						name = "org.jooq.meta.postgres.PostgresDatabase"
						inputSchema = "myschema"
						includes = ".*"
						excludes = ""
					}
					generate.apply {
						isDeprecated = false
						isRecords = true
						isImmutablePojos = true
						isFluentSetters = true
					}
					target.apply {
						packageName = "com.agorohov.jooq.generated"
						directory = "src/generated/java"
					}
				}
			}
		}
	}
}

tasks.named<nu.studer.gradle.jooq.JooqGenerate>("generateJooq") {
	outputs.dir("src/generated/java")
}

tasks.named("compileJava") {
	dependsOn(tasks.named("generateJooq"))
}

tasks.named("clean") {
	doFirst {
		delete("src/generated/java")
	}
}

tasks.named("bootRun") {
	dependsOn(tasks.named("generateJooq"))
}

sourceSets {
	main {
		java {
			srcDir("src/generated/java")
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
