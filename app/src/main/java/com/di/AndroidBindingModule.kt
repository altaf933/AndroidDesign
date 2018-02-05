package com.di

import com.mobiquity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by altafshaikh on 01/02/18.
 */

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector(
            modules = [MainActivityModule::class,
                FragmentBuildersModule::class]
    )
    @ActivityScope
    abstract fun onMainActivity(): MainActivity
}