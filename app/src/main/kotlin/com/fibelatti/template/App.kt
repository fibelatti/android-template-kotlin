package com.fibelatti.template

import android.app.Application
import com.fibelatti.template.di.component.AppComponent
import com.fibelatti.template.di.component.DaggerAppComponent
import com.fibelatti.template.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        buildComponents()
    }

    private fun buildComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
