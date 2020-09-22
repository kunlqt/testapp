package com.arrowhitech.testapp.service

data class LoginResponse(
        val errorCode: String,
        val errorMessage: String,
        val user: User) {

    data class User(
            val userId: String,
            val userName: String
    )
}

data class LoginResponseData(
        var userId: String?,
        var userName: String?,
        var x_acc: String?)