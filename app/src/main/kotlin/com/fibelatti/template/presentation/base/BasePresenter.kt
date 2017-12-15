package com.fibelatti.template.presentation.base

import com.fibelatti.template.presentation.common.SchedulerProvider

abstract class BasePresenter<V : BaseContract.View>(protected val schedulerProvider: SchedulerProvider) : BaseContract.Presenter<V> {
    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    protected fun handleError(error: Throwable = Exception()) {
        view?.hideProgress()
        view?.handleError(error.message)
    }
}
