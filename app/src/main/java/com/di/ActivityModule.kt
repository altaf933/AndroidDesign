package com.di

import android.support.v7.app.AppCompatActivity
import com.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by altafshaikh on 06/02/18.
 */

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    internal abstract fun contributeMainActivity(): MainActivity

    @Binds abstract fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
}