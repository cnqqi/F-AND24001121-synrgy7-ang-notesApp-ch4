package com.synrgy.challenge4.repository

import androidx.lifecycle.LiveData
import com.synrgy.challenge4.database.UserDao
import com.synrgy.challenge4.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun login(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }

    suspend fun register(email: String, username: String, password: String) {
        val user = User(email = email, username = username, password = password)
        userDao.insertUser(user)
    }
}
