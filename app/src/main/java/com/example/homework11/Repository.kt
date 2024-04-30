package com.example.homework11

import android.content.Context

const val SHARED_VALUE = "shared_value"
const val SHARED_KEY = "shared_key"

class Repository(private val context: Context) {
    private val sharedPreference = context.getSharedPreferences(SHARED_VALUE, Context.MODE_PRIVATE)
    private var localDate: String? = getText()

    fun getDataFromSharedPreference(): String? {
        return sharedPreference.getString(SHARED_KEY, null)
    }

    fun getDataLocalVariable(): String? {
        return localDate
    }

    fun saveText(text: String) {
        with(sharedPreference.edit()) {
            putString(SHARED_KEY, text)
            commit()
        }
        localDate = text
    }

    fun clearText() {
        with(sharedPreference.edit()) {
            remove(SHARED_KEY)
            commit()
        }
        localDate = null
    }

    fun getText(): String {

        val textFromLocalDate = getDataLocalVariable()
        if (textFromLocalDate != null) {
            return textFromLocalDate
        } else {
            val textFromSharedData = getDataFromSharedPreference()
            return textFromSharedData ?: ""
        }
    }
}