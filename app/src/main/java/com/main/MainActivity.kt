package com.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.main.sample.R
import com.ui.home.HomeFragment
import com.utils.FragmentNavigation
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, FragmentReplaceListener {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var fragmentNavigate: FragmentNavigation

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onFragmentChange(HomeFragment())
    }

    override fun onFragmentChange(fragment: Fragment) {
        fragmentNavigate.replaceFragment(fragment)
    }

}

interface FragmentReplaceListener {
    fun onFragmentChange(fragment: Fragment)
}
