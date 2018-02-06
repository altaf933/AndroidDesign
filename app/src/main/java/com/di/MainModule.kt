package com.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.di.annotation.ViewModelKey
import com.factory.ViewModelFactory
import com.ui.HomeFragment
import com.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by altafshaikh on 06/02/18.
 */

@Module
internal abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMainViewModel(viewModel: HomeViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): HomeFragment


}