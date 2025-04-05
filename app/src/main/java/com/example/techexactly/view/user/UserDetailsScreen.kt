package com.example.techexactly.view.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.techexactly.model.dataclass.Address
import com.example.techexactly.model.dataclass.Company
import com.example.techexactly.model.dataclass.Geo
import com.example.techexactly.model.dataclass.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    user: User, onBackClicked: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            UserDetailsTopBar(
                title = user.name, scrollBehavior = scrollBehavior, onBackClicked = {
                    onBackClicked()
                })
        }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            UserDetailsScreenContent(user = user)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserDetailsScreenPreview() {
    val user = User(
        id = 1,
        name = "Leanne Graham",
        username = "Bret",
        email = "Sincere@april.biz",
        address = Address(
            "Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", Geo("-37.3159", "81.1496")
        ),
        phone = "1-770-736-8031 x56442",
        website = "hildegard.org",
        company = Company(
            "Romaguera-Crona",
            "Multi-layered client-server neural-net",
            "harness real-time e-markets"
        )
    )
    UserDetailsScreen(user = user, onBackClicked = {})
}