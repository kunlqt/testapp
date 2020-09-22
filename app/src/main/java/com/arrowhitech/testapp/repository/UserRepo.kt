package com.arrowhitech.testapp.repository

import android.util.Log
import com.arrowhitech.testapp.service.LoginRequest
import com.arrowhitech.testapp.service.LoginResponse
import com.arrowhitech.testapp.service.LoginResponseData
import com.arrowhitech.testapp.service.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo(private val loginService: LoginService) {

    fun doLogin(user: LoginRequest, callBack: (LoginResponseData?) -> Unit) {

        val podcastCall = loginService.doLogin(user)

        podcastCall.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("KUNLQT", "error=====" + t.message)
                callBack(null)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("KUNLQT", "RETROFIT_RESPONSE_X-Acc====" + response.headers().get("X-Acc"))
                Log.d("KUNLQT", "RETROFIT_RESPONSE_BODY====" + response.body().toString())

                //for now not check errorCode response, "errorCode": "01","00" is reversed
                if (response.body() != null && response.body()?.user != null && response.headers().get("X-Acc") != null)
                    callBack(LoginResponseData(response.body()!!.user.userId, response.body()!!.user.userName, response.headers().get("X-Acc")!!))
                else
                    callBack(null)
            }

        })

    }
}