package com.example.techexactly.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techexactly.model.dataclass.Address
import com.example.techexactly.model.dataclass.Company
import com.example.techexactly.model.dataclass.Geo
import com.example.techexactly.model.dataclass.User

@Composable
fun UserListItem(user: User, onUserClicked: (User) -> Unit) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
    ) {
        ListItem(
            modifier = Modifier.clickable { onUserClicked(user) },
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                headlineColor = MaterialTheme.colorScheme.onSecondaryContainer,
                supportingColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ),
            leadingContent = {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = user.name.first().toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            },
            headlineContent = {
                Text(
                    text = user.name, style = MaterialTheme.typography.titleLarge
                )
            },
            supportingContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = user.email, style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserListItem() {
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
    UserListItem(user = user, onUserClicked = {})
}