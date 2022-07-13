/*
 * Created by Muhamad Syafii
 * Friday, 14/1/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.db

import android.content.Context
import android.content.SharedPreferences
import com.gibox.testandroid.util.constant.PREF_NAME
import com.google.gson.Gson

class PrefUtils(context : Context) {

    private val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = mSharedPreferences.edit()

    fun saveString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }


    fun saveStringFromObject(key: String?, value: Any?) {
        editor.putString(key, Gson().toJson(value))
        editor.apply()
    }



    fun saveInt(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }


    fun saveLong(key: String?, value: Long) {
        editor.putLong(key, value)
        editor.apply()
    }


    fun saveBoolean(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }


    fun saveFloat(key: String?, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }


    fun clear() {
        editor.clear()
        editor.apply()
    }


    fun getString(key: String?): String? {
        return mSharedPreferences.getString(key, "")
    }


    fun getLong(key: String?): Long {
        return mSharedPreferences.getLong(key, 0L)
    }


    fun getInt(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

    fun getFloat(key: String?): Float {
        return mSharedPreferences.getFloat(key, 0.0f)
    }

    fun getBoolean(key: String?): Boolean {
        return mSharedPreferences.getBoolean(key, false)
    }

}