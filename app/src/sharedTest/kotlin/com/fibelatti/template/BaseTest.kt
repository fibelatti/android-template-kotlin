package com.fibelatti.template

import io.reactivex.observers.TestObserver

abstract class BaseTest {
    protected val testSchedulerProvider = TestSchedulerProvider()

    companion object {
        const val GENERIC_ERROR_MESSAGE = "Error"
    }

    protected fun <T> assertCompletableOnComplete(testObserver: TestObserver<T>) {
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    protected fun <T> assertSingleOnCompleteWithNoErrors(testObserver: TestObserver<T>) {
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
    }

    protected fun mockedRunnable(body: Runnable) {
        body.run()
    }
}
