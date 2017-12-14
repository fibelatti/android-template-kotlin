package com.fibelatti.template.di.module

import com.fibelatti.template.presentation.common.AppSchedulerProvider
import com.fibelatti.template.presentation.common.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}
