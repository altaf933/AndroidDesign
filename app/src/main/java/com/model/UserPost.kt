package com.model

import com.squareup.moshi.Json

data class UserPost(
        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "title")
        val title: String? = null,

        @Json(name = "body")
        val body: String? = null,

        @Json(name = "userId")
        val userId: Int? = null
)