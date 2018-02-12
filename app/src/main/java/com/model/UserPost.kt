package com.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

 class UserPost(

        @PrimaryKey
        @Json(name = "id")
        val id: Int? = null,

        @ColumnInfo (name= "title")
        @Json(name = "title")
        val title: String? = null,

        @ColumnInfo (name= "body")
        @Json(name = "body")
        val body: String? = null,

        @ColumnInfo (name= "userId")
        @Json(name = "userId")
        val userId: Int? = null
)