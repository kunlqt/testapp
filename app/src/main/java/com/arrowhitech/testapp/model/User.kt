package com.arrowhitech.testapp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(
        var userId: String? = "",
        var userName: String? = "",
        var x_acc: String? = ""){

        @PrimaryKey(autoGenerate = true)
        var Id: Long? = null

}