# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Study tool Android app for school students (Class 6–12). Currently ships **Maths only**; other subjects render disabled. Built with **Kotlin** + **Jetpack Compose** + Material 3. Single-module Gradle project (`app`).

- **Package:** `com.example.myapp`
- **Min SDK:** 24 (Android 7.0), **Target/Compile SDK:** 35
- **Java/Kotlin JVM target:** 11 (see `app/build.gradle.kts`)
- **Build system:** Gradle (Kotlin DSL) with version catalog at `gradle/libs.versions.toml`

## Environment Setup

Development happens on macOS without Android Studio. SDK path is in `local.properties`:

```
sdk.dir=/Users/anurag.s/Library/Android/sdk
```

Run Gradle via the wrapper from `study-tool-android/`. If `JAVA_HOME` is unset, point it at a JDK 11+ install before invoking the wrapper.

## Build Commands

Run from `study-tool-android/`:

```bash
./gradlew assembleDebug          # Build debug APK
./gradlew test                   # Unit tests (JUnit 4)
./gradlew lint                   # Android Lint
./gradlew installDebug           # Install on connected device/emulator
./gradlew connectedAndroidTest   # Instrumented tests
./gradlew :app:testDebugUnitTest --tests "com.example.myapp.ExampleUnitTest"   # Single test
```

## Architecture

### Navigation Flow

`Splash → (UserProfile if profile not set) → (LanguageSelection if onboarding not done) → ClassSelection → SubjectSelection → ChapterList → ModuleList → Content`

`Leaderboard` is a side route reachable from the navigation drawer on any post-onboarding screen.

`AppNavGraph` waits for both `hasCompletedProfile` and `hasCompletedOnboarding` to emit (initial=null) before it composes the `NavHost` — this prevents a flash of the wrong start destination. The Splash screen then `popUpTo(0)` navigates to `nextDestination` based on those two flags.

### Layers

- **UI:** Composable screen + ViewModel pairs under `ui/{screen}/`. ViewModels expose `StateFlow` and are constructed via `viewModel { ... }` factory lambdas in `AppNavGraph` (manual DI — no Hilt/Koin).
- **Common UI shell:** `ui/common/AppScaffold.kt` wraps a screen in a `ModalNavigationDrawer` + `TopAppBar` and is reused by ClassSelection, SubjectSelection, ChapterList, ModuleList, and Content. Drawer items: Leaderboard, Settings (no-op), Logout. Pass `firstName`, `lastName`, `userRole`, `onLogout`, `onLeaderboardClick` through from `AppNavGraph`.
- **Data models:** `data/model/` — `Language`, `SchoolClass`, `Subject`, `Chapter`, `Module`, `ContentBlock` (sealed: `TextBlock`, `ExampleBlock`), `Question`/`Option`, `UserRole` (STUDENT/EDUCATOR/PARENT).
- **Content repository:** `ContentRepository` interface, `HardcodedContentRepository` impl. All chapters/modules/content/questions are hardcoded in the `companion object` — designed for future server swap behind the same interface.
- **Preferences:** Single DataStore (`user_prefs`) created in `MainActivity` and shared across:
  - `UserPreferencesRepository` — language, class, onboarding flag, profile (firstName/lastName/role), profile-complete flag, `clearAll()` for logout.
  - `ScoringRepository` — per-module points/attempts/completed, plus an aggregated `totalPoints` Flow. Keys are namespaced: `score_completed_<moduleId>`, `score_points_<moduleId>`, `score_attempts_<moduleId>`. Both repositories share the same `DataStore<Preferences>` instance, so logout's `clearAll()` wipes scores too.
- **Navigation:** Routes in `navigation/Screen.kt`, graph in `navigation/AppNavGraph.kt`.

### Scoring

`ScoringRepository.calculatePoints(attemptNumber)` awards **100 / 50 / 25** points for the 1st / 2nd / 3rd+ attempt at a module. The Content screen owns attempt counting (calls `incrementAttempt`, then `saveModuleScore` when MCQs are submitted). If a module was previously completed, `ContentViewModel` surfaces `alreadyCompleted = true` rather than re-awarding points.

### Leaderboard

`LeaderboardViewModel` merges a hardcoded list of 10 dummy students with the current user's `totalPoints` from `ScoringRepository`, sorts by points desc, and assigns ranks. The current user is tagged via `isCurrentUser` for highlight. Display name is `"$firstName $lastName".trim()` passed in from `AppNavGraph`.

### Adding Content

To add modules/content/questions for a chapter, edit the maps in `HardcodedContentRepository.kt`:
- `modules[chapterId]` → list of `Module(id, chapterId, title, order)`
- `contentBlocks[moduleId]` → list of `ContentBlock.TextBlock` / `ExampleBlock`
- `questions[moduleId]` → list of `Question(id, text, options, correctOptionId, explanation)`

Module IDs follow the convention `c{class}_ch{chapterNum}_m{moduleNum}` (e.g. `c6_ch1_m1`). Chapter lists are defined for all classes 6–12; module/content/question coverage is partial — most populated content lives under Class 6.

### Key Design Notes

- `ContentBlock` is a sealed class — extend with `ImageBlock` / `VideoBlock` rather than overloading `TextBlock`.
- Disabled subjects render with `alpha(0.45f)` and are non-clickable; flag is `Subject.isEnabled`.
- Logout = `userPreferencesRepository.clearAll()` + navigate to Splash with `popUpTo(0) { inclusive = true }`. Because both repositories share the DataStore, this also resets scores.
- Splash uses a 1200ms `LaunchedEffect` delay plus an animated book icon; if you change the delay, keep it short enough that the next-destination decision (already resolved) doesn't feel stalled.

## Key Versions (gradle/libs.versions.toml)

AGP 8.7.3 · Kotlin 2.0.21 · Compose BOM 2024.12.01 · Navigation Compose 2.8.5 · DataStore Preferences 1.1.2 · Lifecycle 2.8.7