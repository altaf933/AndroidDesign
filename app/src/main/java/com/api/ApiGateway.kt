package com.api

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer
import javax.inject.Inject

/**
 * Created by altafshaikh on 05/02/18.
 */

class ApiGateway @Inject constructor() {

    fun <T> subscribeFor(flowable: Flowable<T>,
                         onNextConsumer: (T) -> Unit,
                         onErrorConsumer: (Throwable) -> Unit) {
        flowable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onNextConsumer.invoke(it)
                }, { error: Throwable ->
                    onErrorConsumer.invoke(error)
                })
    }
}