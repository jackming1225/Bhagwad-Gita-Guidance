# 🪔 Gita Wisdom – Spiritual Companion & Daily Reflections

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20(M3)-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-informational)](https://developer.android.com/about/versions/nougat)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-36-informational)](https://developer.android.com/)

A modern, compassionate spiritual companion Android application inspired by the timeless teachings of the **Bhagavad Gita**. Built entirely with modern **Kotlin**, **Jetpack Compose (Material 3)**, and **Room Database**, with optional real-time guidance powered by the **Gemini API**.

---

## ✨ Features

- **Compassionate Dilemma Guidance**:
  - Converse with an empathetic AI spiritual companion grounded in Vedantic philosophy (*Nishkama Karma*, *Samatvam*, *Titiksha*, *Atma-jnana*).
  - Categorizes queries (work stress, grief, anger, focus, purpose, relationships, fear) and matches authentic Bhagavad Gita verses.
  - Returns original Sanskrit, Roman transliteration, native translation, and practical modern action steps.

- **12 Indian Languages Supported**:
  - Full translations and guidance in **English**, **Hindi (हिन्दी)**, **Sanskrit (संस्कृतम्)**, **Tamil (தமிழ்)**, **Telugu (తెలుగు)**, **Bengali (বাংলা)**, **Marathi (मराठी)**, **Gujarati (ગુજરાતી)**, **Kannada (ಕನ್ನಡ)**, **Malayalam (മലയാളം)**, **Odia (ଓଡ଼ିଆ)**, and **Punjabi (ਪੰਜਾਬੀ)**.

- **Offline-First Architecture**:
  - Comprehensive local repository of essential Bhagavad Gita verses with instant keyword & semantic intent matching even when completely offline.
  - Zero disruption when network connectivity is lost.

- **Daily Reflection & Streak Tracker**:
  - Contemplative verse of the day with guided journaling and personal intentions.
  - Tracks consecutive reflection streaks locally with Room persistence.

- **Audio & Pronunciation (Text-to-Speech)**:
  - High-fidelity Text-to-Speech support for Sanskrit shlokas and translations with customizable pitch and speech rate.

- **Collections & Bookmarking**:
  - Save favorite verses, organize by life themes, and export or share wisdom cards with others.

- **Traditional Dakshina Model**:
  - Implements the respectful, voluntary offering principle inspired by Indian tradition (*no paywalls, ads, or locked features*).

---

## 🛠️ Tech Stack & Architecture

- **UI Framework**: 100% Jetpack Compose with Material Design 3 (M3) dynamic theming and typography.
- **Architecture**: Clean MVVM (Model-View-ViewModel) with Kotlin Coroutines and StateFlow.
- **Local Persistence**: Android Jetpack Room with KSP (Kotlin Symbol Processing).
- **Networking & AI**: OkHttp + Moshi for Google Gemini API integration with automatic fallback to local wisdom repositories.
- **Secrets Management**: Secrets Gradle Plugin for secure environment variable injection (`GEMINI_API_KEY`).
- **Media & Audio**: Android Text-to-Speech (TTS) engine integration.

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio** Ladybug (2024.2.1) or newer.
- **JDK**: Java 17 or Java 21 recommended.
- **Android Device / Emulator**: Running Android 7.0 (API level 24) or higher.

### 1. Clone the Repository
```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
```

### 2. Configure Environment Variables (Optional for Gemini AI)

The app functions fully offline using its built-in wisdom library. To enable live Gemini AI guidance:

1. Get an API key from [Google AI Studio](https://aistudio.google.com/).
2. Create a `.env` file in the root project directory (or copy `.env.example`):
   ```bash
   cp .env.example .env
   ```
3. Add your Gemini API key:
   ```properties
   GEMINI_API_KEY=your_actual_gemini_api_key_here
   ```

### 3. Build & Run

#### In Android Studio:
1. Open Android Studio and select **Open**, then select the project root directory.
2. Wait for Gradle sync to complete.
3. Connect your Android device (e.g. OnePlus, Pixel, Samsung) via USB with USB Debugging enabled.
4. Select your device from the device dropdown and click **Run ▶** (or press `Shift + F10`).

#### From Command Line:
```bash
# Build Debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug
```
The generated APK will be located at:
```
app/build/outputs/apk/debug/app-debug.apk
```

---

## 📦 Project Structure

```
├── app/
│   ├── src/main/
│   │   ├── java/com/example/
│   │   │   ├── audio/           # Text-To-Speech engine manager
│   │   │   ├── auth/            # Google Identity & Seeker profile
│   │   │   ├── data/
│   │   │   │   ├── local/       # Room Database, DAOs, and Entities
│   │   │   │   ├── model/       # Data models (GitaVerse, GitaLanguage, etc.)
│   │   │   │   ├── remote/      # Gemini API client & DTOs
│   │   │   │   ├── repository/  # Repository abstraction layer
│   │   │   │   └── wisdom/      # Offline Gita wisdom repository & translations
│   │   │   ├── ui/
│   │   │   │   ├── components/  # Reusable UI widgets & cards
│   │   │   │   ├── screens/     # Chat, Reflections, Favorites, Profile screens
│   │   │   │   ├── theme/       # M3 ColorScheme & Typography
│   │   │   │   └── viewmodel/   # GitaViewModel & StateFlows
│   │   │   └── MainActivity.kt
│   │   └── res/                 # Vectors, adaptive icons, and strings
│   └── build.gradle.kts
├── gradle/                      # Version catalog (libs.versions.toml) & wrapper
├── .env.example
├── .gitignore
├── metadata.json
└── README.md
```

---

## 🔒 Privacy & Data Policy

- All personal notes, chat queries, and reflection journals are stored **locally on the user's device** using Room Database.
- No user dialogue or reflection logs are sold or sent to third-party tracking services.
- If Gemini API is activated, queries are transmitted securely via TLS directly to Google's official Gemini endpoint.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
Feel free to use, adapt, and build upon it with devotion and care.
