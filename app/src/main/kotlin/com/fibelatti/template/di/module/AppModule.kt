package com.fibelatti.template.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.fibelatti.template.App
import com.fibelatti.template.di.qualifier.AppQualifier
import com.fibelatti.template.di.scope.AppScope
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class AppModule(private var app: App) {

    @Provides
    @AppScope
    fun provideApp(): App = app

    @Provides
    @AppScope
    @AppQualifier
    fun provideContext(): Context = app.applicationContext

    @Provides
    @AppScope
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    fun provideLocaleDefault(): Locale = Locale.getDefault()
}
