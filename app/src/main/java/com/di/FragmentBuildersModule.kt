package com.di

import com.ui.home.HomeFragment
import com.ui.homedetail.HomeDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by altafshaikh on 02/02/18.
 */

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeDetailFragment(): HomeDetailFragment
}