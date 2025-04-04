package com.example.techexactly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techexactly.model.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            userRepository.getUsers().collect { result ->
                when (result.isSuccess) {
                    true -> {
                        val users = result.getOrNull() ?: emptyList()
                        _uiState.value = UiState.Success(users)
                    }

                    false -> {
                        val exception = result.exceptionOrNull()
                        _uiState.value = UiState.Error(exception?.message ?: "Unknown Error")
                    }
                }
            }
        }
    }
}