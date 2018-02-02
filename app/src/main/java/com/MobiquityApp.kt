package com

import android.app.Activity
import android.app.Application
import com.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

/**
 * Created by altafshaikh on 01/02/18.
 */

class MobiquityApp : Application(), HasActivityInjector {

    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        configureDependencyInjection()
    }

    private fun configureDependencyInjection() {
        DaggerAppComponent.builder()
                .application(this)
                .create(this)
                .inject(this)
    }
}