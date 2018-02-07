package com.common

/**
 * Created by altafshaikh on 05/02/18.
 */
sealed class ResultMapper<out S, out F> {
    data class Success<out S, out F>(val success: S) : ResultMapper<S, F>()
    data class Failure<out S, out F>(val failour: F) : ResultMapper<S, F>()
}