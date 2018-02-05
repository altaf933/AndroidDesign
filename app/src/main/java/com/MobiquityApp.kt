package com

import android.app.Activity
import android.app.Application
import com.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by altafshaikh on 01/02/18.
 */

class MobiquityApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        configureDependencyInjection()
    }

    private fun configureDependencyInjection() {
        DaggerAppComponent.builder()
                .application(this)
                .create(this)
                .inject(this)
    }
}