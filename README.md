# OSINT Toolkit

Android app with 124 OSINT tools organized in 30 categories. Features smart input detection that identifies email, phone, IP, domain, username, and other data types, then suggests the best tool for the job.

## Features

- **124 tools** across 30 categories (Search Engines, Username, Email, Phone, VK, Instagram, Telegram, Domain/IP, Breaches, Malware, Maps, Transport, and more)
- **Smart Search** — detects input type (Email, Phone, IP, Domain, Username, Hash, Coordinates) and opens the best matching tool
- **Favorites** — save frequently used tools
- **In-app WebView** — open tools without leaving the app
- Pixel-art hacker icon

## Tech Stack

- Kotlin, Android SDK
- ViewBinding, RecyclerView
- Material Design 3
- NeoForge AGP 8.2.2, Gradle 8.2

## Build

Requires Android Studio or `sdkmanager` with build-tools 34:

```bash
./gradlew assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`

## Categories

Search Engines · Username · Email · Phone · VK · Facebook · Instagram · Twitter · YouTube · Telegram · Discord · TikTok · Reverse Image · Maps · Satellite · Transport · Domain/IP · Archives · Breaches · Malware · Business · Documents · Dark Web · Crypto · Government · People · Geolocation · Metadata · Password · General
