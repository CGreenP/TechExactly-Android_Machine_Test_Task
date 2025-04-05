package com.example.techexactly

import android.app.Application
import com.example.techexactly.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 *  The main application class for the TechExactly application.  This class
 *  initializes Koin, the dependency injection framework, during the application's
 *  `onCreate` lifecycle event.
 */
class TechExactlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TechExactlyApplication)
            modules(appModule)
        }
    }
}