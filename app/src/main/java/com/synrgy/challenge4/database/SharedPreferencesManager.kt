package com.synrgy.challenge4.database

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "MySharedPreferences",
        Context.MODE_PRIVATE
    )

    companion object {
        private const val KEY_EMAIL = "email"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }

    var email: String?
        get() = sharedPreferences.getString(KEY_EMAIL, null)
        set(value) = sharedPreferences.edit().putString(KEY_EMAIL, value).apply()

    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
}
