package com.example.techexactly.viewmodel

import com.example.techexactly.model.dataclass.User

sealed class UiState {
    data object Loading : UiState()
    data class Success(val users: List<User>) : UiState()
    data class Error(val errorMessage: String) : UiState()
}