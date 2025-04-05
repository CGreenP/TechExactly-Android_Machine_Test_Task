package com.example.techexactly.view.user

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MarkunreadMailbox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Signpost
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.techexactly.model.dataclass.Address
import com.example.techexactly.model.dataclass.Company
import com.example.techexactly.model.dataclass.Geo
import com.example.techexactly.model.dataclass.User

@Composable
fun UserDetailsBody(user: User) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = CardDefaults.elevatedShape
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            UserDetailsItem(icon = Icons.Default.Person, title = "Name", value = user.name)
            UserDetailsItem(
                icon = Icons.Default.AlternateEmail,
                title = "Username",
                value = user.username
            )
            UserDetailsItem(icon = Icons.Default.Email, title = "Email", value = user.email)
            UserDetailsItem(icon = Icons.Default.Call, title = "Phone", value = user.phone)
            UserDetailsItem(icon = Icons.Default.Language, title = "Website", value = user.website)
            UserDetailsItemAddress(
                icon = Icons.Default.Home,
                title = "Address",
                address = user.address
            )
            UserDetailsItemCompany(
                icon = Icons.Default.Apartment,
                title = "Company",
                company = user.company
            )
        }
    }
}

@Composable
fun UserDetailsItem(
    icon: ImageVector, title: String, value: String
) {
    ListItem(leadingContent = {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }, headlineContent = {
        Text(
            text = title, style = MaterialTheme.typography.bodyMedium
        )
    }, supportingContent = {
        Text(
            text = value, style = MaterialTheme.typography.titleLarge
        )
    })
}

@Composable
fun UserDetailsItemAddress(
    icon: ImageVector, title: String, address: Address
) {
    ListItem(leadingContent = {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }, headlineContent = {
        Text(
            text = title, style = MaterialTheme.typography.bodyMedium
        )
    }, supportingContent = {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            UserDetailsItemAddressRow(
                icon = Icons.Default.Signpost, title = "Street", value = address.street
            )
            UserDetailsItemAddressRow(
                icon = Icons.Default.Apartment, title = "Suite", value = address.suite
            )
            UserDetailsItemAddressRow(
                icon = Icons.Default.LocationCity, title = "City", value = address.city
            )
            UserDetailsItemAddressRow(
                icon = Icons.Default.MarkunreadMailbox,
                title = "Zipcode",
                value = address.zipcode
            )
            UserDetailsItemAddressRow(
                icon = Icons.Default.LocationOn,
                title = "Geo",
                value = "Latitude: ${address.geo.lat}\nLongitude: ${address.geo.lng}"
            )
        }
    })
}

@Composable
fun UserDetailsItemAddressRow(
    icon: ImageVector, title: String, value: String
) {
    ListItem(leadingContent = {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
        )
    }, headlineContent = {
        Text(
            text = title, style = MaterialTheme.typography.bodyMedium
        )
    }, supportingContent = {
        Text(
            text = value, style = MaterialTheme.typography.titleMedium
        )
    })
}

@Composable
fun UserDetailsItemCompany(
    icon: ImageVector, title: String, company: Company
) {
    ListItem(leadingContent = {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }, headlineContent = {
        Text(
            text = title, style = MaterialTheme.typography.bodyMedium
        )
    }, supportingContent = {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            UserDetailsItemCompanyRow(
                icon = Icons.Default.CorporateFare, title = "Name", value = company.name
            )
            UserDetailsItemCompanyRow(
                icon = Icons.Default.RecordVoiceOver,
                title = "Catchphrase",
                value = company.catchPhrase
            )
            UserDetailsItemCompanyRow(
                icon = Icons.Default.Work, title = "Bs", value = company.bs
            )
        }
    })

}

@Composable
fun UserDetailsItemCompanyRow(
    icon: ImageVector, title: String, value: String
) {
    ListItem(leadingContent = {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
        )
    }, headlineContent = {
        Text(
            text = title, style = MaterialTheme.typography.bodyMedium
        )
    }, supportingContent = {
        Text(
            text = value, style = MaterialTheme.typography.titleMedium
        )
    })
}


@Preview
@Composable
fun UserDetailsBodyPreview() {
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
    UserDetailsBody(user)
}