# # Kotlin Android Optimization Toolkit 🚀

A collection of practical Kotlin utilities, Gradle configurations, and best practices designed to help Android developers reduce app size, improve performance, and optimize the user experience.

## 📦 Contents

- **`build.gradle.kts`**: Recommended configuration for R8, ProGuard, and resource shrinking to reduce APK/AAB size.
- **`ImageOptimizer.kt`**: A Kotlin utility to compress and scale bitmaps efficiently to save memory and storage.
- **`ScreenMetricsHelper.kt`**: A helper to handle screen densities and dimensions for better UI performance.

## 🛠️ How to use

1. Copy the required Kotlin file into your `utils` or `helpers` package.
2. Review the `build.gradle.kts` snippet and apply the necessary configurations to your app-level build file.
3. Ensure you test thoroughly after applying ProGuard/R8 rules to avoid stripping essential code.

## 👨‍💻 Author

**Wisam** - Native Android Developer (Kotlin) & Technical Writer.
- [GitHub Profile](https://github.com/wisammusa95-oss)
- [Technical Report: App Size Reduction](https://github.com/wisammusa95-oss/android-app-size-reduction)

## 📜 License

This project is licensed under the MIT License.
