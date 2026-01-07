package com.example.puydufou.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("PuyDuFouPrefs", Context.MODE_PRIVATE)

    fun saveUserCredentials(username: String, password: String) {
        sharedPreferences.edit().apply {
            putString("username", username)
            putString("password", password)
            apply()
        }
    }

    fun getRememberedUser(): String {
        return sharedPreferences.getString("username", "") ?: ""
    }

    fun saveTheme(theme: String) {
        sharedPreferences.edit().putString("theme", theme).apply()
    }

    fun getTheme(): String {
        return sharedPreferences.getString("theme", "system") ?: "system"
    }

    fun saveLanguage(language: String) {
        sharedPreferences.edit().putString("language", language).apply()
    }

    fun getLanguage(): String {
        return sharedPreferences.getString("language", "es") ?: "es"
    }

    fun areNotificationsEnabled(): Boolean {
        return sharedPreferences.getBoolean("notifications", true)
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        sharedPreferences.edit().putBoolean("notifications", enabled).apply()
    }
}