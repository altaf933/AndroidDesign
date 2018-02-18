package com.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "posts")
data class UserPost(

        @PrimaryKey
        @Json(name = "id")
        val id: Int?,

        @ColumnInfo (name= "title")
        @Json(name = "title")
        val title: String?,

        @ColumnInfo (name= "body")
        @Json(name = "body")
        val body: String?,

        @ColumnInfo (name= "userId")
        @Json(name = "userId")
        val userId: Int?
)