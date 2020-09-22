package com.arrowhitech.testapp.repository

import android.util.Log
import com.arrowhitech.testapp.db.UserDao
import com.arrowhitech.testapp.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginDataRepo(private var userDao: UserDao) {
    fun save(user: User) {
        GlobalScope.launch {
            val userID = userDao.insertUser(user)
            Log.d("KUNLQT", "userID ROOM====" + userID + "-----userid====" + user.userId)
        }
    }
}