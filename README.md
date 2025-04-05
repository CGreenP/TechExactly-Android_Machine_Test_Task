# TechExactly - Android Machine Test Task
This Android application fetches and displays a list of users from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/users), demonstrating core Android development skills using modern Jetpack Compose and architectural patterns.

## Overview
1.  **Main Screen (Home Screen):** Displays a scrollable list of users, with each list item showing the user's name and email. It also features a search bar to filter the user list by name.
2.  **Details Screen:** When a user is selected from the list, this screen shows detailed information about the user, including their name, email, phone number, address, and company information.

## Screenshot
<p align="center">
<img src="https://github.com/user-attachments/assets/a0c9bc1f-98de-422c-b6b4-c0436b5e6ce3" width="288">
<img src="https://github.com/user-attachments/assets/73b2b8ce-2513-4950-a291-a0e9f6ac92b9" width="288">
<img src="https://github.com/user-attachments/assets/2c4e7414-b7c1-4d4e-be41-a5b979fb5146" width="288">
<img src="https://github.com/user-attachments/assets/a6c8f3e0-8efb-4a13-9e52-77ac89a274f0" width="288">
<img src="https://github.com/user-attachments/assets/df64d600-ba68-44e5-ad0c-7ec40728149f" width="288">
<img src="https://github.com/user-attachments/assets/8be88016-abf9-418c-bf1f-144108fae239" width="288">
<img src="https://github.com/user-attachments/assets/44ff56c6-bb43-4c1d-b7a3-d1e89a89fd59" width="288">
<img src="https://github.com/user-attachments/assets/d155f3a4-d8c1-4523-a9be-22d474baaaf7" width="288">
</p>

## Video
https://github.com/user-attachments/assets/eebedd38-df78-4dca-ac1e-f100969caad2

## Features
-   **User Listing:** Fetches and displays a list of users from the JSONPlaceholder API.
-   **Detailed User Information:** Displays comprehensive user details on a separate screen.
-   **Search Functionality:** Allows filtering of users by name using a search bar.
-   **MVVM Architecture:** Implements the Model-View-ViewModel architectural pattern for separation of concerns and testability.
-   **Dependency Injection:** Uses Koin for dependency injection, simplifying object creation and management.
-   **Asynchronous Data Fetching:** Employs Kotlin Coroutines and Flows for handling network requests and data updates asynchronously.
-   **Jetpack Compose:** Leverages Jetpack Compose for building a modern, declarative UI.
-   **State Management:** Utilizes StateFlow for efficient state management and UI updates.
-   **Splash Screen:** Displays a splash screen while the app loads.
-   **Error Handling:** The application handles network errors and display relevant message to the user.
-   **No Data Handling:** The application checks if there is no data and display a message accordingly.
-   **Pagination:** A footer is added to indicate the end of the data.
-   **Clear Search:** The search can be cleared if the user enters any text.

## Tech Stack
-   **Android:** Kotlin
-   **Jetpack Compose:** Declarative UI framework
-   **Koin:** Dependency Injection
-   **Retrofit:** Network requests
-   **OkHttp:** HTTP client for network requests
-   **Kotlin Coroutines:** Asynchronous operations
-   **Kotlin Flows:** Asynchronous stream of data
-   **StateFlow:** State management
-   **MVVM:** Architectural pattern
-   **Splash Screen API:** To show splash screen.
-   **Nested Scroll API:** To add nested scroll.
-   **Material 3:** Modern Material design.
-   **Lifecycle KTX:** To have composable function collectAsStateWithLifecycle

## Dependencies
The project uses the following key dependencies:
-   **Koin**
-   **Retrofit**
-   **OkHttp**
-   **Gson**
-   **Jetpack Compose**
-   **ViewModel**
-   **Compose Navigation**
-   **Serialization**
-   **Splash Screen**
-   **Compose Material Icons Extended**

## Setup and Installation
1.  **Clone the Repository:**
```bash
git clone https://github.com/CGreenP/TechExactly-Android_Machine_Test_Task.git
```
3.  **Open in Android Studio:**
    -   Launch Android Studio.
    -   Select "Open an existing Android Studio project."
    -   Navigate to the cloned repository and open the `app` directory.
4.  **Build and Run:**
    -   Click the "Sync Project with Gradle Files" button.
    -   Once the project is synchronized, click the "Run" button (green play icon) or use `Shift + F10` to build and run the application on an emulator or connected device.

## Architecture
The application follows the **MVVM (Model-View-ViewModel)** architectural pattern:
-   **Model:**
    -   `User.kt`: Data class representing the structure of a user and associated data.
    - `UserApi.kt`: Defines the network call for fetching users from the remote API.
    -   `UserRepository.kt`: Handles the logic for fetching user data from the API and returning it as a `Flow`.
-   **View:**
    -   Composable functions in the `view` package, such as `HomeScreen.kt`, `UserDetailsScreen.kt`, `UserList.kt`, `UserListItem.kt`, etc., are responsible for displaying the UI.
    -   Utilizes Jetpack Compose components (e.g., `LazyColumn`, `Scaffold`, `TopAppBar`, `Text`, `Icon`) to create the UI.
    - The navigation is configured via the NavGraph.
-   **ViewModel:**
    -   `MainViewModel.kt`: Manages the state and business logic for the Home screen.
    -   Exposes `StateFlow`s (`uiState`, `searchQuery`) that the View observes to update the UI.
    -   Fetches user data through the `UserRepository` and processes the results.
    -   Handles search query updates and filters the user list.
 
## Dependency Injection (Koin)
-   **Koin** is used for dependency injection to provide the necessary dependencies to the components (e.g., `Retrofit`, `UserApi`, `UserRepository`, `MainViewModel`).
-   `TechExactlyApplication.kt`: Initializes Koin with the necessary modules.
-   `AppModule.kt`: Defines the Koin modules.

## Data Fetching (Retrofit, OkHttp, Gson, Coroutines, Flows)
-   **Retrofit** is used to make network requests to the JSONPlaceholder API.
-   **OkHttp** is the underlying HTTP client that Retrofit uses.
-   **Gson** is used for JSON serialization/deserialization.
-   **Kotlin Coroutines** are used to handle asynchronous operations and `suspend` functions.
-   **Kotlin Flows** are used to emit data asynchronously from the `UserRepository` to the `MainViewModel`.
-  **Okhttp Logging Interceptor** is used to log the http requests and responses.

## State Management (StateFlow)
-   **StateFlow** is used in `MainViewModel` to hold and update the UI state (`UiState`).
-   The UI state is a `sealed class` (`UiState`) that defines the possible states of the UI (e.g., `Loading`, `Success`, `Error`).
-   The composable functions in the View observe the `StateFlow`s and update the UI accordingly using `collectAsStateWithLifecycle`.

## Navigation
- `NavGraph.kt` : contains the navigation logic between screens.
- `Screens.kt` : defines the routes of the screen.
- `CustomNavType.kt`: defines the way the User object is parsed.

## Additional Features
- **Search Functionality:** The app implements a search feature that allows users to filter the user list by name using the search bar.
- **Clean Code:** The codebase is clean, readable, and well-structured.
- **Modern UI:** Uses Jetpack Compose to build a modern and intuitive UI.
- **Splash Screen:** Displays a splash screen while the app loads.
- **Error Handling:** The application handles network errors and display relevant message to the user.
- **No Data Handling:** The application checks if there is no data and display a message accordingly.
- **Pagination:** A footer is added to indicate the end of the data.
- **Clear Search:** The search can be cleared if the user enters any text.

## Further Improvements
-   **Pagination:** Implement pagination to load more users as the user scrolls.
-   **Caching:** Add a caching mechanism to reduce the number of network requests.
-   **Unit Tests:** Add unit tests for the ViewModel and Repository.
-   **UI Tests:** Add UI tests to verify the UI components.
-   **More Detailed Error Handling:** Provide more detailed error messages and handling for various error scenarios.

## Contact
Chayan Pal
- Mail: [chayan110201@gmail.com](mailto:chayan110201@gmail.com)
- LinkedIn: [www.linkedin.com/in/chayan-pal/](https://www.linkedin.com/in/chayan-pal/)

