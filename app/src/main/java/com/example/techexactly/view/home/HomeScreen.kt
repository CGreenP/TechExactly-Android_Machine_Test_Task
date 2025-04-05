package com.example.techexactly.view.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.techexactly.R
import com.example.techexactly.model.dataclass.User
import com.example.techexactly.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * The main screen of the application, displaying a list of users and a search bar.
 *
 * @param onUserClicked Callback function invoked when a user item in the list is clicked.  It takes a [User] object as a parameter representing the clicked user.
 * @param mainViewModel The [MainViewModel] instance used to manage the data and state for the screen, defaults to an instance retrieved from Koin.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onUserClicked: (User) -> Unit, mainViewModel: MainViewModel = koinViewModel<MainViewModel>()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val searchQuery by mainViewModel.searchQuery.collectAsStateWithLifecycle()

    BackHandler(
        enabled = searchQuery.isNotEmpty(), onBack = {
            mainViewModel.setSearchQuery("")
        })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeScreenTopBar(
                title = stringResource(id = R.string.app_name),
                subtitle = "Users",
                scrollBehavior = scrollBehavior,
                searchQuery = searchQuery,
                onSearchQueryChanged = { newQuery ->
                    mainViewModel.setSearchQuery(newQuery)
                },
                clearSearchQuery = {
                    mainViewModel.setSearchQuery("")
                })
        }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HomeScreenContent(onUserClicked = onUserClicked, mainViewModel = mainViewModel)
        }
    }
}