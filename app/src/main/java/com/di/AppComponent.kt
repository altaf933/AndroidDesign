package com.di

import android.app.Application
import com.MobiquityApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */

@Singleton
@Component(modules = [
    (ViewModelModule::class),
    (AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (MainActivityBuilder::class),
    (NetworkModule::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MobiquityApp)
}