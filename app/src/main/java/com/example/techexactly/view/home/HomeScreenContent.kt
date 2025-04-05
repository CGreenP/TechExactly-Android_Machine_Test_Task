package com.example.techexactly.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.techexactly.model.dataclass.User
import com.example.techexactly.viewmodel.MainViewModel
import com.example.techexactly.viewmodel.UiState

@Composable
fun HomeScreenContent(
    onUserClicked: (User) -> Unit, mainViewModel: MainViewModel
) {
    val uiState by mainViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when (val state = uiState) {
            is UiState.Error -> {
                Text(
                    text = state.errorMessage,
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            is UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is UiState.Success -> {
                UserList(users = state.users, onUserClicked = onUserClicked)
            }
        }
    }
}