package com.example.techexactly.model.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

/**
 * Provides a configured Retrofit instance for making network requests.
 *
 * This function sets up a Retrofit client with the following features:
 * - **Base URL:** Uses the [BASE_URL] constant as the base URL for all requests.  Ensure this constant is defined in your project.
 * - **OkHttpClient:**  Uses an OkHttpClient to handle the network communication, configured with:
 *   - **Logging Interceptor:**  An [HttpLoggingInterceptor] that logs the request and response bodies at the `BODY` level, aiding in debugging.  **Note:**  This should be removed or adjusted for production builds.
 * - **Gson Converter Factory:** Uses a [GsonConverterFactory] to serialize and deserialize JSON responses using the Gson library.  The Gson instance is configured to be lenient, allowing for some flexibility in the expected JSON structure.
 *
 * @return A configured [Retrofit] instance ready for creating API interfaces.
 */
fun provideRetrofit(): Retrofit {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    val gson = GsonBuilder().setLenient().create()

    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson)).build()
}

/**
 * Provides an instance of the [UserApi] interface.
 *
 * This function uses a pre-configured [Retrofit] instance to create an implementation of the [UserApi] interface,
 * which is used to interact with the user-related endpoints of the API.  This abstraction allows for easier testing
 * and decoupling of the network layer from the rest of the application.
 *
 * @param retrofit A configured [Retrofit] instance.  This instance should already be configured with the base URL,
 *                  converter factories (e.g., GsonConverterFactory), and any necessary interceptors (e.g., for authentication).
 * @return An instance of [UserApi] that can be used to make API calls related to users.
 */
fun provideUserApi(retrofit: Retrofit): UserApi {
    return retrofit.create(UserApi::class.java)
}