# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Study tool Android app for school students (Class 6-12). Currently supports **Maths** only. Built with **Kotlin** + **Jetpack Compose** + Material 3. Single-module project (`app`).

- **Package:** `com.example.myapp`
- **Min SDK:** 24 (Android 7.0), **Target/Compile SDK:** 35
- **Build system:** Gradle with Kotlin DSL and version catalogs

## Environment Setup

JDK and Android SDK are installed locally (no Android Studio):

- **JDK 17:** `D:\tools\jdk-17.0.18+8`
- **Android SDK:** `D:\tools\android-sdk`
- **local.properties** points Gradle to the SDK

When running Gradle from bash, set environment first:
```bash
export JAVA_HOME="/d/tools/jdk-17.0.18+8"
export PATH="$JAVA_HOME/bin:$PATH"
```

To build: `java -classpath "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain assembleDebug`

## Build Commands

```bash
./gradlew assembleDebug          # Build debug APK
./gradlew test                   # Run unit tests
./gradlew lint                   # Lint check
./gradlew installDebug           # Install on device
./gradlew connectedAndroidTest   # Instrumented tests
```

## Architecture

### Navigation Flow
Language Selection → Class Selection → Subject Selection → Chapter List → Module List → Content (with MCQ)

### Layers
- **UI layer:** Composable screens + ViewModels (StateFlow). Each screen pair lives in its own package under `ui/`.
- **Data layer:** Repository pattern. `ContentRepository` interface with `HardcodedContentRepository` (designed for future server swap).
- **Persistence:** DataStore Preferences via `UserPreferencesRepository` (saves language, class selection, onboarding state).
- **Navigation:** Jetpack Navigation Compose. Routes defined in `navigation/Screen.kt`, graph in `navigation/AppNavGraph.kt`.
- **DI:** Manual — repositories created in `MainActivity`, passed to ViewModels via factory lambdas.

### Package Structure
```
com.example.myapp/
├── MainActivity.kt                   # Entry point, creates repos, sets up NavHost
├── data/model/                       # Data classes: Language, SchoolClass, Subject, Chapter, Module, ContentBlock, Question
├── data/repository/                  # ContentRepository interface + HardcodedContentRepository
├── data/preferences/                 # UserPreferencesRepository (DataStore)
├── navigation/                       # Screen routes + AppNavGraph
└── ui/{screen}/                      # Screen + ViewModel pairs (language, classselection, subjectselection, chapterlist, modulelist, content)
```

### Key Design Decisions
- `ContentBlock` is a sealed class (TextBlock, ExampleBlock) — extend with ImageBlock/VideoBlock for richer content later
- Language selection pops itself from backstack after onboarding — back from ClassSelection exits the app
- Disabled subjects (Physics, Chemistry, etc.) use `alpha(0.45f)` and are non-clickable
- MCQ answers are tracked in ViewModel state; scoring happens on submit with explanations revealed

### Content Data Status
- Chapters defined for all classes 6-12
- Modules defined for Class 6 (all chapters)
- Full content + questions exist for: c6_ch1_m1, c6_ch1_m2, c6_ch2_m1, c6_ch2_m2
- Remaining modules need content added in `HardcodedContentRepository.kt`

## Key Versions (in gradle/libs.versions.toml)

- AGP: 8.7.3, Kotlin: 2.0.21, Compose BOM: 2024.12.01, Gradle: 8.10.2
- Navigation Compose: 2.8.5, DataStore Preferences: 1.1.2
