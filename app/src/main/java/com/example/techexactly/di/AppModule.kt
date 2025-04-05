package com.example.techexactly.di

import com.example.techexactly.model.network.provideRetrofit
import com.example.techexactly.model.network.provideUserApi
import com.example.techexactly.model.repository.UserRepository
import com.example.techexactly.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Koin module defining dependencies related to the application's core functionalities.
 * It includes:
 *  - Retrofit instance for network communication.
 *  - User API interface implementation.
 *  - UserRepository instance for accessing user data.
 *  - MainViewModel instance for managing the main screen's data and logic.
 */
val appModule = module {
    single { provideRetrofit() }
    single { provideUserApi(get()) }
    single { UserRepository(get()) }

    viewModelOf(::MainViewModel)
}