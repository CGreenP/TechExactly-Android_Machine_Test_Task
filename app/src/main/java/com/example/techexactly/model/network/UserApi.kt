package com.example.techexactly.model.network

import com.example.techexactly.model.dataclass.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>>
}