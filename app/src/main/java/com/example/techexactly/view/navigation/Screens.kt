package com.example.techexactly.view.navigation

import com.example.techexactly.model.dataclass.User
import kotlinx.serialization.Serializable

/**
 * Sealed class representing the different destinations within the application.  This allows for type-safe navigation
 * between screens.  Each subclass of `Dest` represents a unique screen, and can optionally contain data needed to
 * display that screen (e.g., user details).  The use of `@Serializable` on both the sealed class and its data subclasses
 * enables serialization and deserialization, allowing for persistence of navigation state (e.g., for deep linking or
 * restoring state after app termination).
 */
sealed class Dest {

    @Serializable
    data object HomeScreen : Dest()

    @Serializable
    data class UserDetailsScreen(val user: User) : Dest()

}