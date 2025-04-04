package com.example.techexactly.model.repository

import com.example.techexactly.model.dataclass.User
import com.example.techexactly.model.network.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val userApi: UserApi) {
    fun getUsers(): Flow<Result<List<User>>> = flow {
        try {
            // Switch to Dispatchers.IO for the network call.
            val response = userApi.getUsers()
            if (response.isSuccessful) {
                // Handle success case.
                val users = response.body() ?: emptyList()
                emit(Result.success(users))
            } else {
                // Handle HTTP error cases.
                emit(Result.failure(Exception("Error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            // Handle any exception during the network call.
            emit(Result.failure(Exception("Error fetching users: ${e.message}")))
        }
    }.flowOn(Dispatchers.IO) // Use flowOn to change the context of the flow to Dispatchers.IO
}