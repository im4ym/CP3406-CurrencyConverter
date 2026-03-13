# Currency Converter — CP3406 Assignment 1

A utility-style Android app that provides live currency conversion using real-time exchange rates.

---

## Features

- Convert between 30+ world currencies using live exchange rates
- Swap button to instantly flip the From/To currencies
- Settings screen to set default currencies and decimal places
- Loading indicator while fetching data
- Error handling for network failures
- Clean Material Design 3 UI

---

## How to Run

1. Clone this repository
2. Open in Android Studio
3. Let Gradle sync complete
4. Run on an emulator or physical device (API 26+)

---

## API

This app uses the [Frankfurter API](https://www.frankfurter.app/) for live exchange rates.

- No API key required
- Free and open source
- Endpoint used: `https://api.frankfurter.app/latest?amount=X&from=XXX&to=XXX`
- Currencies endpoint: `https://api.frankfurter.app/currencies`

---

## Architecture

This app follows the **MVVM (Model-View-ViewModel)** architecture pattern:

- **Model** — `ConversionResult.kt` data class maps the API response
- **Network** — `FrankfurterApiService.kt` defines the Retrofit API interface
- **Repository** — `CurrencyRepository.kt` handles all data fetching and sits between the API and ViewModel
- **ViewModel** — `CurrencyViewModel.kt` holds UI state and exposes data to the UI via StateFlow
- **View** — `MainActivity.kt` contains all Jetpack Compose UI composables

---

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose + Material Design 3
- **Architecture:** MVVM + Repository Pattern
- **Networking:** Retrofit 2 + Gson Converter
- **API:** Frankfurter (free, no auth)
- **Version Control:** GitHub

---

## Project Structure
```
app/src/main/java/au/edu/jcu/cp3406_cp5307_utilityappstartertemplate/
├── model/
│   └── ConversionResult.kt
├── network/
│   └── FrankfurterApiService.kt
├── repository/
│   └── CurrencyRepository.kt
├── viewmodel/
│   └── CurrencyViewModel.kt
├── ui/theme/
│   └── Theme.kt
└── MainActivity.kt
```

---

## Author

Ye Mon Aung — CP5307 Advanced Mobile Technologies, James Cook University
```