package com.example.techexactly.di

import com.example.techexactly.model.network.provideRetrofit
import com.example.techexactly.model.network.provideUserApi
import com.example.techexactly.model.repository.UserRepository
import org.koin.dsl.module

val appModule = module {
    single { provideRetrofit() }
    single { provideUserApi(get()) }
    single { UserRepository(get()) }
}