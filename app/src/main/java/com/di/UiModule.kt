package com.di

/**
 * Created by altafshaikh on 06/02/18.
 */
import android.arch.lifecycle.ViewModelProvider
import com.factory.ViewModelFactory
import com.mobiquity.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class UiModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}