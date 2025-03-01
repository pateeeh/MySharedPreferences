package com.example.mysharedpreferences

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email

internal class UserPreference(context: Context) {
    companion object{
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val LOVE_ML = "islove"
    }
    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    fun setUser(value: UserModel) {
        val editor = preferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phone)
        editor.putBoolean(LOVE_ML, value.isLove)
        editor.apply()
    }
    fun getUser(): UserModel{
        val model = UserModel()
        model.name = preferences.getString(NAME, "")
        model.email = preferences.getString(EMAIL, "")
        model.age = preferences.getInt(AGE, 0)
        model.phone = preferences.getString(PHONE_NUMBER, "")
        model.isLove = preferences.getBoolean(LOVE_ML, false)
        return model
    }
}