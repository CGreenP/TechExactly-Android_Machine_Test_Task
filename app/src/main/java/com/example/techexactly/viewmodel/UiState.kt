package com.example.techexactly.viewmodel

import com.example.techexactly.model.dataclass.User

/**
 * Represents the different states of a UI, typically related to data loading and display.
 */
sealed class UiState {
    data object Loading : UiState()
    data class Success(val users: List<User>) : UiState()
    data class Error(val errorMessage: String) : UiState()
}