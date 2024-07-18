# Android Clean Architecture Kotlin
This repository demonstrates the implementation of a clean architecture approach for an Android application using Kotlin. It includes all the boilerplate code for API integration and follows the architectural pattern with Use Cases, utilizing Retrofit for API calls, Koin for dependency injection, and Kotlin Flows and Coroutines for asynchronous operations.

# Features

Kotlin Language: The entire codebase is written in Kotlin.

Retrofit: Used for making API calls.

Koin: Dependency injection framework to manage dependencies.

Kotlin Flows and Coroutines: For handling asynchronous operations.

MVVM Clean Architecture: Separation of concerns with a clear architecture.

Two Screen App: A basic application with two screens demonstrating the architecture and integration.

# Architecture

The project follows the MVVM clean architecture pattern which divides the code into three main layers:

Presentation Layer: Contains the UI-related components like Activities and ViewModels.

Domain Layer: Contains business logic, represented by Use Cases.

Data Layer: Responsible for data management, including API calls and data persistence.

# Project Structure

data: Contains API service definitions, repository implementations, and data models.

di: Contains Koin modules for dependency injection.

domain: Contains domain models, repository interfaces, and use cases.

presentation: Contains UI components (views) and their corresponding ViewModels.

utils: Utility classes and extension functions.

App.kt: The application class for initializing the app.

# Installation
1: Clone the repository:

2: Open the project in Android Studio.

3: Sync the project with Gradle files.

# Usage

Replace the base URL in data/api/ApiService.kt with your API's base URL.

Define your API endpoints in ApiService.kt.

Create your data models in the data/model package.

Implement the repository in data/repository package.

Define your use cases in the domain/usecase package.

Implement your ViewModels in the presentation/viewmodel package.

Update the UI in the presentation/view package as needed.

# Dependency Injection with Koin

Dependencies are managed using Koin. Modules are defined in the di package. To add a new dependency:

Create a new Koin module in the di package.

Define your dependency in the module.

Add the module to the startKoin function in App.kt.

Asynchronous Operations with Kotlin Flows and Coroutines

Kotlin Flows and Coroutines are used to handle asynchronous operations. Use Flows for data streams and Coroutines for background tasks. Example usage can be found in the repository and viewmodel packages.

# License
This project is licensed under The GNU General Public License v3 - see the [LICENSE.md](LICENSE.md) file for details

# Contributing
Contributions are welcome! Please create a pull request or open an issue for any changes or suggestions.

# Contact
For any questions or inquiries, please contact waleedtalha00@gmail.com or create an issue on this repository.
