package com.arrowhitech.testapp.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @Headers(
        "Content-Type: application/json",
        "IMSI: 357175048449937",
        "IMEI: 510110406068589"
    )
    @POST("/api/login")
    fun doLogin(@Body user: LoginRequest): Call<LoginResponse>

    companion object {
        val instance: LoginService by lazy {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://private-222d3-homework5.apiary-mock.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            retrofit.create<LoginService>(LoginService::class.java)
        }
    }
}