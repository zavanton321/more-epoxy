package ru.zavanton.epoxy.app

import android.app.Application
import ru.zavanton.epoxy.BuildConfig
import ru.zavanton.epoxy.di.AppComponent
import ru.zavanton.epoxy.di.AppModule
import ru.zavanton.epoxy.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    companion object {

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        super.onCreate()

        initializeLogging()
    }

    private fun initializeLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(CustomDebugTree())
        }
    }
}