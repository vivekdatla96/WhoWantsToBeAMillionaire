# Who Wants to Be a Millionaire

An Android trivia game inspired by the TV quiz format: answer ten questions in a row to win.

## How it plays

- Splash screen, then a start screen
- Ten questions, one per screen, each worth more than the last
- Your running earnings are shown on every question
- A wrong answer ends the game on the Game Over screen with your earnings
- Answer all ten correctly to reach the Victory screen

## Build and run

Requirements: Android Studio (Hedgehog or newer) or JDK 17 with the Android SDK, `compileSdk` 34.

```bash
./gradlew assembleDebug    # APK in app/build/outputs/apk/debug/
./gradlew installDebug     # install on a connected device or emulator
```

Minimum Android version: API 24 (Android 7.0).

## Author

Vivek Datla
