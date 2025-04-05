package com.example.techexactly.model.dataclass

import kotlinx.serialization.Serializable

/**
 * Represents a user with their personal and professional information.
 *
 * @property id The unique identifier of the user.
 * @property name The full name of the user.
 * @property username The username or alias of the user.
 * @property email The email address of the user.
 * @property address The address details of the user, including street, city, etc.
 * @property phone The phone number of the user.
 * @property website The website associated with the user.
 * @property company The company details of the user, including name and other information.
 */
@Serializable
data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
)

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo,
)

@Serializable
data class Geo(
    val lat: String,
    val lng: String,
)

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String,
)