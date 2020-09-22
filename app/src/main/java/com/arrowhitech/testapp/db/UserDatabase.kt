package com.arrowhitech.testapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.arrowhitech.testapp.model.User
import android.content.Context

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        UserDatabase::class.java, "User").build() }
            return instance as UserDatabase
        }
    } }