package com.arrowhitech.testapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arrowhitech.testapp.R
import com.arrowhitech.testapp.viewmodel.LoginViewModel
import com.arrowhitech.testapp.viewmodel.UserViewModel

class LogedinActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logedin)
    }
}