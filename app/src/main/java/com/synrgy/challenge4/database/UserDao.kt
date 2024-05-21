package com.synrgy.challenge4.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.synrgy.challenge4.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Insert
    suspend fun insertUser(user: User)
}
