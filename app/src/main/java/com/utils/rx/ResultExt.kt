package com.utils.rx

import com.common.ResultMapper
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * Created by altafshaikh on 08/02/18.
 */


fun <T> Flowable<T>.toResult(schedulerProvider: SchedulerProvider): Flowable<ResultMapper<T>> {

    return compose { item ->
        item
                .map { ResultMapper.success(it) }
                .onErrorReturn { e -> ResultMapper.error(e) }
                .observeOn(schedulerProvider.ui())
                .subscribeOn(Schedulers.newThread())
    }
}