package com.arrowhitech.testapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.arrowhitech.testapp.model.User
import com.arrowhitech.testapp.repository.LoginDataRepo

class UserViewModel(application: Application) : AndroidViewModel
(application) {
    var userRepo: LoginDataRepo? = null
    private var activeUser: User? = null

    fun saveActiveUser(username: String?, password: String?, x_acc: String?) {
        val loginDetails = User(username, password, x_acc)
        val repo = userRepo ?: return
        repo.save(loginDetails)

    }
}