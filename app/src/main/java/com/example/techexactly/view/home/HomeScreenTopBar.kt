package com.example.techexactly.view.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techexactly.R

/**
 * Composable function for the top app bar of the Home Screen.
 *
 * This composable displays a centered top app bar with the app logo, title, subtitle, and a search bar.
 * The search bar can be toggled via a search icon button, and it filters the displayed content based on user input.
 *
 * @param title The main title to display in the top bar.
 * @param subtitle The subtitle to display below the main title.
 * @param scrollBehavior The scroll behavior for the top app bar, handling scrolling effects.
 * @param searchQuery The current search query string. Defaults to an empty string.
 * @param onSearchQueryChanged Callback function invoked when the search query changes. It receives the new query string as a parameter.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    title: String, subtitle: String,
    scrollBehavior: TopAppBarScrollBehavior,
    searchQuery: String = "",
    onSearchQueryChanged: (String) -> Unit,
    clearSearchQuery: () -> Unit,
) {
    var showSearchBar by remember { mutableStateOf(false) }
    Column {
        CenterAlignedTopAppBar(
            title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title, maxLines = 1, overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = subtitle, style = MaterialTheme.typography.labelMedium
                )
            }
        }, actions = {
            AnimatedVisibility(visible = showSearchBar) {
                IconButton(
                    onClick = { showSearchBar = !showSearchBar }) {
                    Icon(
                        imageVector = Icons.Default.Close, contentDescription = "Close"
                    )
                }
            }
            AnimatedVisibility(visible = !showSearchBar) {
                IconButton(
                    onClick = { showSearchBar = !showSearchBar }) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = "Search"
                    )
                }
            }
        }, navigationIcon = {
            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    MaterialTheme.colorScheme.onSurface
                )
            )
        }, scrollBehavior = scrollBehavior
        )
        AnimatedVisibility(visible = showSearchBar) {
            DockedSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                inputField = {
                    SearchBarDefaults.InputField(
                        modifier = Modifier.fillMaxWidth(0.9f),
                        query = searchQuery,
                        onQueryChange = {
                            onSearchQueryChanged(it)
                        },
                        onSearch = {
                            showSearchBar = false
                        },
                        expanded = false,
                        onExpandedChange = { },
                        placeholder = { Text("Search Users") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search, contentDescription = null
                            )
                        },
                        trailingIcon = {
                            if (showSearchBar) {
                                IconButton(onClick = {
                                    if (searchQuery.isNotEmpty()) {
                                        clearSearchQuery()
                                    }
                                    showSearchBar = false
                                }) {
                                    Icon(Icons.Default.Close, contentDescription = null)
                                }
                            }

                        })
                },
                expanded = false,
                onExpandedChange = {}) {}
        }
        AnimatedVisibility(searchQuery.isNotEmpty()) {
            Text(
                text = "Showing results for: $searchQuery",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBarPreview() {
    HomeScreenTopBar(
        title = stringResource(id = R.string.app_name),
        subtitle = "Users",
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
        searchQuery = "",
        onSearchQueryChanged = {},
        clearSearchQuery = {})
}