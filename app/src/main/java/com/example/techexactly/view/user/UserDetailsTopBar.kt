package com.example.techexactly.view.user

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

/**
 * Composable function that creates a top app bar for the user details screen.
 *
 * @param title The title to display in the top app bar.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to handle scrolling behavior of the top app bar.  This allows for collapsing/expanding behavior.  Typically provided by a `TopAppBarDefaults.enterAlwaysScrollBehavior()` or similar.
 * @param onBackClicked Callback function to be executed when the back button is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsTopBar(
    title: String, scrollBehavior: TopAppBarScrollBehavior, onBackClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = { onBackClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun UserDetailsTopBarPreview() {
    UserDetailsTopBar(
        title = "User Details",
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
        onBackClicked = {})
}