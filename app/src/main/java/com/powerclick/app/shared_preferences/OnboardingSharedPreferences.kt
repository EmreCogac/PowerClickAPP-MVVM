package com.powerclick.app.shared_preferences

import android.content.Context
import android.content.SharedPreferences


class OnboardingSharedPreferences(context: Context) {
    private val prefs : SharedPreferences =
        context.getSharedPreferences("isFirstTime", Context.MODE_PRIVATE)

    fun getBool(key : String, defValue: Boolean): Boolean{
        return prefs.getBoolean(key,defValue)
    }

    fun setBool(key : String, defValue: Boolean){
        prefs.edit().putBoolean(key,defValue).apply()
    }


}