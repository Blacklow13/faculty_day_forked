plugins {
    buildlogic.`kotlin-common-conventions-no-detekt`
    kotlin("jvm") version "1.9.0"
    id("buildlogic.kotlin-library-conventions")
}
dependencies {
    testImplementation(kotlin("test"))
}
