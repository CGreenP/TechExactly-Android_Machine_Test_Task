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

/**
 * Composable function to display the details of a user in a card format.
 *
 * @param user The [User] object containing the user's information to be displayed.
 */
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
                icon = Icons.Default.AlternateEmail, title = "Username", value = user.username
            )
            UserDetailsItem(icon = Icons.Default.Email, title = "Email", value = user.email)
            UserDetailsItem(icon = Icons.Default.Call, title = "Phone", value = user.phone)
            UserDetailsItem(icon = Icons.Default.Language, title = "Website", value = user.website)
            UserDetailsItemAddress(
                icon = Icons.Default.Home, title = "Address", address = user.address
            )
            UserDetailsItemCompany(
                icon = Icons.Default.Apartment, title = "Company", company = user.company
            )
        }
    }
}

/**
 * Composable function to display a user detail item in a list format.
 *
 * @param icon The icon to be displayed in the leading content.  Should be an [ImageVector].
 * @param title The title of the detail item, displayed as the headline.
 * @param value The value of the detail item, displayed as the supporting content.
 */
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

/**
 * Composable function to display user address details in a ListItem.
 *
 * @param icon The icon to display representing the address.
 * @param title The title of the address section (e.g., "Address").
 * @param address The [Address] object containing the address information.
 */
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
                icon = Icons.Default.MarkunreadMailbox, title = "Zipcode", value = address.zipcode
            )
            UserDetailsItemAddressRow(
                icon = Icons.Default.LocationOn,
                title = "Geo",
                value = "Latitude: ${address.geo.lat}\nLongitude: ${address.geo.lng}"
            )
        }
    })
}

/**
 * Composable function to display a user detail item row representing an address.
 *
 * @param icon The icon to be displayed at the start of the row.  Typically an address-related icon like [Icons.Outlined.LocationOn].
 * @param title The title of the address detail, e.g., "Address" or "Shipping Address".  Displayed using `MaterialTheme.typography.bodyMedium`.
 * @param value The actual address value to be displayed.  Displayed using `MaterialTheme.typography.titleMedium`.
 */
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

/**
 * Composable function to display company details within a user details list item.
 *
 * @param icon The leading icon for the list item, representing the company.
 * @param title The title of the list item, e.g., "Company".
 * @param company The [Company] object containing the company's information to display.  It will display the company name, catchphrase and business.
 */
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
                icon = Icons.Default.Work, title = "Business", value = company.bs
            )
        }
    })

}

/**
 * A composable function that displays a row of user details, specifically for company-related information.
 * It consists of an icon, a title, and a value.  It uses a Material 3 `ListItem` to structure the row.
 *
 * @param icon The icon to display at the start of the row, representing the detail type (e.g., a company logo or building icon).
 * @param title The title or label for the detail, describing what information is being shown (e.g., "Company Name").
 * @param value The actual value of the detail, which will be displayed below the title (e.g., "Acme Corp").
 */
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