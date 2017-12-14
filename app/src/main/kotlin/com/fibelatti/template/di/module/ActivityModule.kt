package com.fibelatti.template.di.module

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import com.fibelatti.template.presentation.common.DialogHelper
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @Provides
    fun provideContext(): Context = activity.baseContext

    @Provides
    fun provideActivity(): FragmentActivity = activity

    @Provides
    fun provideDialogBuilder(context: Context): AlertDialog.Builder = AlertDialog.Builder(context)

    @Provides
    fun provideDialogHelper(alertDialogBuilder: AlertDialog.Builder) = DialogHelper(alertDialogBuilder)
}
