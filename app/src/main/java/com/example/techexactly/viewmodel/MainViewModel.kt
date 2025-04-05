package com.example.techexactly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techexactly.model.dataclass.User
import com.example.techexactly.model.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _allUsers = MutableStateFlow<List<User>>(emptyList())
    val allUsers: StateFlow<List<User>> = _allUsers.asStateFlow()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            userRepository.getUsers().collect { result ->
                when (result.isSuccess) {
                    true -> {
                        val users = result.getOrNull() ?: emptyList()
                        _uiState.value = UiState.Success(users)
                        _allUsers.value = users
                        filterUsers()
                    }

                    false -> {
                        val exception = result.exceptionOrNull()
                        _uiState.value = UiState.Error(exception?.message ?: "Unknown Error")
                    }
                }
            }
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
        filterUsers()
    }

    private fun filterUsers() {
        val filteredUsers = if (_searchQuery.value.isBlank()) {
            _allUsers.value
        } else {
            _allUsers.value.filter { user ->
                user.name.contains(_searchQuery.value, ignoreCase = true)
            }
        }
        _uiState.value = UiState.Success(filteredUsers)
    }
}