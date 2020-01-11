package ru.zavanton.epoxy.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.zavanton.epoxy.ui.MainActivity
import javax.inject.Scope

@Scope
@Retention
annotation class ApplicationScope

@Scope
@Retention
annotation class ActivityScope

@ApplicationScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun mainActivityComponent(): MainActivityComponent
}

@Module
class AppModule(private val appContext: Context) {

    @ApplicationScope
    @Provides
    fun provideAppContext(): Context = appContext
}

@ActivityScope
@Subcomponent(
    modules = [
        MainActivityModule::class
    ]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}

@Module
class MainActivityModule