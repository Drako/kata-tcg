import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.0"
}

object Versions {
  const val ASSERTK = "0.12"
  const val JUNIT = "5.3.1"
  const val KOIN = "1.0.1"
  const val MOCKITO_KOTLIN = "2.0.0"
  
  object KotlinX {
    const val COROUTINES = "1.0.0"
  }
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  compile(kotlin("stdlib"))
  compile(kotlin("stdlib-jdk7"))
  compile(kotlin("stdlib-jdk8"))
  compile(kotlin("reflect"))
  testCompile(kotlin("test"))
  testCompile(kotlin("test-junit5"))

  compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.KotlinX.COROUTINES}")
  compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinX.COROUTINES}")

  testCompile("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}")
  testCompile("org.junit.jupiter:junit-jupiter-params:${Versions.JUNIT}")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT}")

  testCompile("com.willowtreeapps.assertk:assertk-jvm:${Versions.ASSERTK}")
  testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}")
  
  compile("org.koin:koin-core:${Versions.KOIN}")
  testCompile("org.koin:koin-test:${Versions.KOIN}")
}

val test: Test by tasks
test.useJUnitPlatform()

tasks.withType(KotlinCompile::class.java).all {
  kotlinOptions.jvmTarget = "1.8"
}
