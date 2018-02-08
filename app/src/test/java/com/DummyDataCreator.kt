package com

import android.icu.lang.UScript
import com.model.UserPost

/**
 * Created by altafshaikh on 08/02/18.
 */
object DummyDataCreator {

    fun getPosts(): List<UserPost> {
        var listMutableUserPost = mutableListOf<UserPost>()
        for (i in 1..10) {
            var userPost = UserPost(i, "title $i", "body $i")
            listMutableUserPost.add(userPost)
        }
        return listMutableUserPost
    }
}
