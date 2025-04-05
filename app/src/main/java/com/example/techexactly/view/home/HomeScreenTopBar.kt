package com.example.techexactly.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.techexactly.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(
    title: String, subtitle: String, scrollBehavior: TopAppBarScrollBehavior
) {
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
    }, navigationIcon = {}, scrollBehavior = scrollBehavior
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBarPreview() {
    HomeScreenTopBar(
        title = stringResource(id = R.string.app_name),
        subtitle = "Users",
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}