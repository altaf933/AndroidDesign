package com.ui.homedetail

import android.arch.lifecycle.ViewModel
import com.db.UsersPostsRepository
import javax.inject.Inject

/**
 * Created by altafshaikh on 20/02/18.
 */

class HomeDetailViewModel @Inject constructor(var repository: UsersPostsRepository) : ViewModel() {

}