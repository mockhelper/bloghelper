package com.mockhelper.organizer.persistense

import android.content.Context
import android.content.SharedPreferences

class Persistence(context: Context) {

    private var PRIVATE_MODE = 0
    private val PREFS_FILENAME = "com.mockhelper.organizer.prefs"

    private val PREF_NAME = "blog-organizer"

    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, PRIVATE_MODE)
}