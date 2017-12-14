package com.fibelatti.template.di.component

import com.fibelatti.template.di.module.ActivityModule
import com.fibelatti.template.di.module.AppModule
import com.fibelatti.template.di.module.PresenterModule
import com.fibelatti.template.di.scope.AppScope
import dagger.Component

@Component(
        modules = [AppModule::class]
)
@AppScope
interface AppComponent {
    fun plus(activityModule: ActivityModule, presenterModule: PresenterModule): PresentationComponent
}

