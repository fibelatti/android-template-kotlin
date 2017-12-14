package com.fibelatti.template.presentation.home

import android.os.Bundle
import android.widget.FrameLayout
import com.fibelatti.template.R
import com.fibelatti.template.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_toolbar_default.*

class HomeActivity :
        BaseActivity() {

    override val rootLayout: FrameLayout?
        get() = layout_root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getPresentationComponent(this).inject(this)

        setUpLayout()
    }

    private fun setUpLayout() {
        setSupportActionBar(toolbar)
    }
}
