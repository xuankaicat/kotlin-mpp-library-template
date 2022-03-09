allprojects {
    group = "com.github.xuankaicat"
    version = "dev"

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.freeCompilerArgs += "-Xmulti-platform"
    }
}