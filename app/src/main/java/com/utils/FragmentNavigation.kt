package com.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.main.sample.R
import javax.inject.Inject

/**
 * Created by altafshaikh on 05/02/18.
 */

class FragmentNavigation @Inject constructor(private var appCompatActivity: AppCompatActivity) {
    private val containerId: Int = R.id.content
    private val fragmentManager: FragmentManager = appCompatActivity.supportFragmentManager

    fun replaceFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}