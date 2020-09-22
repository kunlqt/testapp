package com.arrowhitech.testapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import com.arrowhitech.testapp.repository.UserRepo
import com.arrowhitech.testapp.service.LoginRequest
import com.arrowhitech.testapp.service.LoginResponse
import com.arrowhitech.testapp.service.LoginResponseData

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var userRepo: UserRepo? = null

    fun doLogin(username: String, password: String, callback: (LoginResponseData?) -> Unit) {

        userRepo?.doLogin(LoginRequest(username, password)) { result ->
            if (result == null) {
                callback(null)
            } else {
                Log.d("KUNLQT", "RESPONSE_x_acc====" + result.x_acc)
                callback(result)
            }
        }
    }
}