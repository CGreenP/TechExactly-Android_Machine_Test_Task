package com.example.techexactly

import android.app.Application
import com.example.techexactly.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TechExactlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TechExactlyApplication)
            modules(appModule)
        }
    }
}