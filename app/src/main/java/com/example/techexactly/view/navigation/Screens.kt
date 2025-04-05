package com.example.techexactly.view.navigation

import com.example.techexactly.model.dataclass.User
import kotlinx.serialization.Serializable

sealed class Dest {

    @Serializable
    data object HomeScreen : Dest()

    @Serializable
    data class UserDetailsScreen(val user: User) : Dest()

}