package com.example.w2w.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceHelper {
    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(Enum.PREF_NAME.value, Context.MODE_PRIVATE)
    }

    fun read(key: String, value: String? = null): String? {
        return prefs.getString(key, value)
    }

    fun write(key: String, value: String?) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            apply()

        }
    }

    fun remove(key: String){
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        prefsEditor.remove(key)
        prefsEditor.apply()
    }
}