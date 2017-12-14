package com.fibelatti.template.di.component

import com.fibelatti.template.di.module.ActivityModule
import com.fibelatti.template.di.module.PresenterModule
import com.fibelatti.template.di.scope.PresentationScope
import com.fibelatti.template.presentation.base.BaseActivity
import com.fibelatti.template.presentation.home.HomeActivity
import dagger.Subcomponent

@Subcomponent(
        modules = [ActivityModule::class, PresenterModule::class]
)
@PresentationScope
interface PresentationComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(homeActivity: HomeActivity)
}
