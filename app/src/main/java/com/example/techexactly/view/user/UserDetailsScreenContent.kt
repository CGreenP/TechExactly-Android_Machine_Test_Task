package com.example.techexactly.view.user

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techexactly.model.dataclass.Address
import com.example.techexactly.model.dataclass.Company
import com.example.techexactly.model.dataclass.Geo
import com.example.techexactly.model.dataclass.User

/**
 * Composable function that displays the main content of the user details screen.
 *
 * It uses a [LazyColumn] to efficiently display the user's information, which can include a header
 * and a body section.  The content is arranged vertically and centered horizontally within the available width.
 *
 * @param user The [User] object containing the details to be displayed.  Must not be null.
 */
@Composable
fun UserDetailsScreenContent(
    user: User
) {

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri.value = uri
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            UserDetailsHeader(
                user = user,
                profileImageUri = selectedImageUri.value,
                onEditClick = {
                    imagePickerLauncher.launch("image/*")
                }
            )
        }
        item {
            UserDetailsBody(user = user)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserDetailsScreenContent() {
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
    UserDetailsScreenContent(user)
}