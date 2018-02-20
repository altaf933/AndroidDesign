package com.di

import android.arch.lifecycle.ViewModelProvider
import com.factory.ViewModelFactory
import com.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by altafshaikh on 01/02/18.
 */

@Module
abstract class MainActivityBuilder {

    @ContributesAndroidInjector(
            modules = [MainActivityModule::class,
                FragmentBuildersModule::class])

    abstract fun onMainActivity(): MainActivity
}