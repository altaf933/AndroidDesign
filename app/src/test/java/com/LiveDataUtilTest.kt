package com

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by altafshaikh on 08/02/18.
 */
object LiveDataUtilTest {

    /**
     * Obtain the live data vale with an time out
     *
     * https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/app/src/test-common/java/com/android/example/github/util/LiveDataTestUtil.java
     */
    fun <T> getLiveDataValue(liveData: LiveData<T>, timeOutInSeconds: Long = 2): T? {
        var value: T? = null
        val lock = CountDownLatch(1)
        var liveDataSet = false
        val observer = object : Observer<T> {

            override fun onChanged(t: T?) {
                value = t
                liveDataSet = true
                lock.countDown()
                liveData.removeObserver(this)
            }

        }
        liveData.observeForever(observer)
        lock.await(timeOutInSeconds, TimeUnit.SECONDS)
        if (!liveDataSet) {
            throw AssertionError("Unable to retrieve LiveData value due timeout. It was $timeOutInSeconds seconds")
        }
        return value
    }
}