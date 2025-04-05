package com.example.techexactly.view.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.techexactly.model.dataclass.User
import kotlinx.serialization.json.Json

/**
 *  Custom Navigation Type for complex objects (in this case, a User object).  Allows passing
 *  objects as navigation arguments instead of just simple types.  Uses Kotlin Serialization
 *  to encode/decode the object as a JSON string for storage in a Bundle or URI.
 */
object CustomNavType {
    val UserType = object : NavType<User>(
        isNullableAllowed = false
    ) {
        override fun get(
            bundle: Bundle, key: String
        ): User? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): User {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: User): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(
            bundle: Bundle, key: String, value: User
        ) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }
}