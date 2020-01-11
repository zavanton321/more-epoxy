package ru.zavanton.epoxy.app

import android.app.Application
import ru.zavanton.epoxy.BuildConfig
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeLogging()
    }

    private fun initializeLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(CustomDebugTree())
        }
    }
}