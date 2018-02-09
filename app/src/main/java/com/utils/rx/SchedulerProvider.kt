package com.utils.rx

/**
 * Created by altafshaikh on 08/02/18.
 */
import io.reactivex.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler

    fun computation(): Scheduler

    fun newThread(): Scheduler

    fun io(): Scheduler
}