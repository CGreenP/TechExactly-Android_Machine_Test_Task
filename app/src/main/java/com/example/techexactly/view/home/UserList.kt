package com.example.techexactly.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techexactly.model.dataclass.Address
import com.example.techexactly.model.dataclass.Company
import com.example.techexactly.model.dataclass.Geo
import com.example.techexactly.model.dataclass.User

@Composable
fun UserList(users: List<User>, onUserClicked: (User) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(users, key = { it.id }) { user ->
            UserListItem(user = user, onUserClicked = onUserClicked)
        }
        item {
            UserListFooter()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserList() {
    val users = listOf(
        User(
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
        ), User(
            id = 2,
            name = "Ervin Howell",
            username = "Antonette",
            email = "Shanna@melissa.tv",
            address = Address(
                "Victor Plains",
                "Suite 879",
                "Wisokyburgh",
                "90566-7771",
                Geo("-43.9509", "-34.4618")
            ),
            phone = "010-692-6593 x09125",
            website = "anastasia.net",
            company = Company(
                "Deckow-Crist", "Proactive didactic contingency", "synergize scalable supply-chains"
            ),
        ), User(
            id = 3,
            name = "Clementine Bauch",
            username = "Samantha",
            email = "Nathan@yesenia.net",
            address = Address(
                "Douglas Extension",
                "Suite 847",
                "McKenziehaven",
                "59590-4157",
                Geo("-68.6102", "-47.0653")
            ),
            phone = "1-463-123-4447",
            website = "ramiro.info",
            company = Company(
                "Romaguera-Jacobson",
                "Face to face bifurcated interface",
                "e-enable strategic applications"
            )
        )
    )

    UserList(users = users, onUserClicked = {})
}