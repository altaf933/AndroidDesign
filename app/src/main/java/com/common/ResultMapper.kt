package com.common

/**
 * Created by altafshaikh on 05/02/18.
 */
open class ResultMapper<T> {

    data class Success<T>(val data: T) : ResultMapper<T>()
    data class Failure<T>(val errorMessage: Throwable) : ResultMapper<T>()

    companion object {
        fun <T> success(data: T): ResultMapper<T> = Success<T>(data)
        fun <T> error(error: Throwable): ResultMapper<T> = Failure<T>(error)
    }
}