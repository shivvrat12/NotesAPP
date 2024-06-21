# Notes App with Swipe to Delete

This project is a modern Notes app for Android, built using Jetpack Compose. It features swipe-to-delete functionality for each note, Hilt for dependency injection, and a sleek, user-friendly interface.

## Features

- Create, read, update, and delete notes.
- Swipe to delete functionality for easy note management.
- Modern UI design using Jetpack Compose.
- Dependency injection with Hilt.
- Persist notes using Room database.

## Setup Instructions
use the new-notes-app branch and clone it into your device

## Screenshots
![Screenshot_20240621_195225_New-Notes-App](https://github.com/shivvrat12/NotesAPP/assets/132883626/1fa7e3c3-028a-4e27-a2e1-194053b619d2)
![Screenshot_20240621_195342_New-Notes-App](https://github.com/shivvrat12/NotesAPP/assets/132883626/f25fc4c4-16e4-446e-9d3c-b30ff2c049b6)
![Screenshot_20240621_195357_New-Notes-App](https://github.com/shivvrat12/NotesAPP/assets/132883626/aec801bc-f5c2-4779-8519-44f1b5a224ca)
### Prerequisites

- Android Studio 4.2 or higher
- Gradle 7.0 or higher

### Dependencies

The project uses the following dependencies:

```gradle
dependencies {
    implementation "androidx.compose.ui:ui:1.0.0"
    implementation "androidx.compose.material:material:1.0.0"
    implementation "androidx.compose.ui:ui-tooling-preview:1.0.0"
    implementation "androidx.room:room-runtime:2.3.0"
    kapt "androidx.room:room-compiler:2.3.0"
    implementation 'com.google.dagger:hilt-android:2.35'
    kapt 'com.google.dagger:hilt-compiler:2.35'
    implementation "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
}
