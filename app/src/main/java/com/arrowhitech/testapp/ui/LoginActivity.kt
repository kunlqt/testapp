package com.arrowhitech.testapp.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.arrowhitech.testapp.R
import com.arrowhitech.testapp.db.UserDatabase
import com.arrowhitech.testapp.repository.LoginDataRepo
import com.arrowhitech.testapp.repository.UserRepo
import com.arrowhitech.testapp.service.LoginService
import com.arrowhitech.testapp.viewmodel.LoginViewModel
import com.arrowhitech.testapp.viewmodel.UserViewModel

class LoginActivity: AppCompatActivity(){
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        var context = this@LoginActivity

        val btn_login = findViewById(R.id.btn_login) as Button
        val txtUsername = findViewById(R.id.username) as EditText
        val txtPassword = findViewById(R.id.password) as EditText
        val error_username = findViewById(R.id.error_username) as TextView
        val error_password = findViewById(R.id.error_password) as TextView

        val service = LoginService.instance
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.userRepo = UserRepo(service)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val db = UserDatabase.getInstance(this)
        val userDao = db.userDao()
        userViewModel.userRepo = LoginDataRepo(userDao)

        // set on-click listener
        btn_login.setOnClickListener {
            Toast.makeText(this@LoginActivity, "You clicked login.", Toast.LENGTH_SHORT).show()
            val strUsername = txtUsername.text.toString().trim()
            val strPassword = txtPassword.text.toString().trim()

            if (strUsername.isEmpty()) {
                error_username.visibility = View.VISIBLE
                error_username.text = "Please enter the username"
                txtUsername.error = "Please enter the username"
            }
            else if (strPassword.isEmpty()) {
                error_password.visibility = View.VISIBLE
                error_password.text = "Please enter the password"
                txtPassword.error = "Please enter the password"
            }
            else{
                performSearch(strUsername, strPassword)
            }
        }
    }

    private fun performSearch(username: String, password: String) {
//        showProgressBar()
        loginViewModel.doLogin(username, password) { result ->
//            hideProgressBar()
            if (result != null) {
                Log.d("KUNLQT", "ATIVITYLOGIN_RESPONSE_x_acc====" + result.x_acc)
                userViewModel.saveActiveUser(result.userId, result.userName, result.x_acc)
                val loginIntent = Intent(this, LogedinActivity::class.java)
                startActivity(loginIntent)
            }

        }
    }
}