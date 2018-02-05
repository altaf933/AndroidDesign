package com.di

import android.app.Application
import com.MobiquityApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */

@Singleton
@Component(modules = [(AppModule::class),
    (AndroidBindingModule::class),
    (FragmentBuildersModule::class),
    (NetworkModule::class)
])
interface AppComponent : AndroidInjector<MobiquityApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MobiquityApp>() {

        @BindsInstance
        abstract fun application(application: Application): AppComponent.Builder
    }
}