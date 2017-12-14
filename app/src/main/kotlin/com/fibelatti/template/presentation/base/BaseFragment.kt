package com.fibelatti.template.presentation.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.fibelatti.template.R

abstract class BaseFragment : Fragment(), BaseContract.View {
    private lateinit var progressBarLayout: View
    private lateinit var placeholderRetryLayout: View

    private var progressBarLayoutAdded = false
    private var errorLayoutAdded = false

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBarLayout = layoutInflater.inflate(R.layout.layout_progress_bar_default, rootLayout, false)
        placeholderRetryLayout = layoutInflater.inflate(R.layout.layout_placeholder_retry_button, rootLayout, false)
    }

    override fun showProgress() {
        rootLayout?.let {
            if (!progressBarLayoutAdded) {
                it.addView(progressBarLayout)

                progressBarLayout.bringToFront()

                progressBarLayoutAdded = true
            }
        }
    }

    override fun hideProgress() {
        rootLayout?.let {
            if (progressBarLayoutAdded) {
                it.removeView(progressBarLayout)
                progressBarLayoutAdded = false
            }
        }
    }

    protected fun showErrorLayout(retryButtonListener: () -> Unit, errorMessage: String = getString(R.string.generic_msg_error)) {
        rootLayout?.let {
            if (!errorLayoutAdded) {
                val textViewErrorMessage = placeholderRetryLayout.findViewById<AppCompatTextView>(R.id.textView_errorMessage)
                val retryButton = placeholderRetryLayout.findViewById<AppCompatButton>(R.id.button_retry)

                textViewErrorMessage.text = errorMessage

                retryButton.setOnClickListener {
                    hideErrorLayout()
                    retryButtonListener()
                }

                it.addView(placeholderRetryLayout)

                placeholderRetryLayout.bringToFront()

                errorLayoutAdded = true
            }
        }
    }

    private fun hideErrorLayout() {
        rootLayout?.let {
            it.removeView(placeholderRetryLayout)
            errorLayoutAdded = false
        }
    }

    protected fun showDismissibleHint(container: ViewGroup, hintTitle: String = getString(R.string.hint_did_you_know), hintMessage: String) {
        container.let {
            val layoutHint = layoutInflater.inflate(R.layout.layout_dismissible_hint, container, false)

            with(layoutHint) {
                val textViewHintTitle = findViewById<AppCompatTextView>(R.id.textView_hintTitle)
                val layoutHintBody = findViewById<FrameLayout>(R.id.layout_hintBody)
                val buttonHintDismiss = findViewById<AppCompatTextView>(R.id.button_hintDismiss)
                val textViewHintMessage = layoutInflater.inflate(R.layout.layout_dismissible_hint_text, layoutHintBody, false) as AppCompatTextView

                textViewHintTitle.text = hintTitle
                textViewHintMessage.text = hintMessage

                layoutHintBody.addView(textViewHintMessage)

                buttonHintDismiss.setOnClickListener { container.removeView(layoutHint) }
            }

            it.addView(layoutHint)
        }
    }
}
