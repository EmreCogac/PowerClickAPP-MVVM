package com.powerclick.app.shared_preferences

import android.content.Context


class OnboardingSharedPreferences(private val context: Context) {


    private val PREF_FILE_KEY = "onboarding_completed"
    private val PREF_KEY_TUTORIAL_1 = "tutorial_fragment_1_completed"

    private val sharedPreferences = context.getSharedPreferences(PREF_FILE_KEY, Context.MODE_PRIVATE)

    fun setOnboardingCompleted(completed: Boolean) {
        sharedPreferences.edit().putBoolean(PREF_KEY_TUTORIAL_1, completed).apply()
    }

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean(PREF_KEY_TUTORIAL_1, false)
    }
}