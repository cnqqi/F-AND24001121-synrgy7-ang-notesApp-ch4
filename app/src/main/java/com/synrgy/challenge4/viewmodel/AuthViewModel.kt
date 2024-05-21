package com.synrgy.challenge4.viewmodel

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.synrgy.challenge4.database.AppDatabase
import com.synrgy.challenge4.database.UserDao
import com.synrgy.challenge4.model.User
import com.synrgy.challenge4.repository.UserRepository

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    suspend fun login(username: String, password: String): User? {
        return userRepository.login(username, password)
    }

    suspend fun register(email: String, username: String, password: String) {
        userRepository.register(email, username, password)
    }
}

