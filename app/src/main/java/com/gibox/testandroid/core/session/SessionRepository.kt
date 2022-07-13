/*
 * Created by Muhamad Syafii
 * Wednesday, 26/1/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.session

import com.gibox.testandroid.util.constant.*

class SessionRepository(private val sesi:SessionManager) {
    fun loginUser(tokenType:String,accessToken: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(TOKEN_TYPE, tokenType)
        sesi.saveToPreference(ACCESS_TOKEN,accessToken)
    }

    fun setDataUser(uiduser:String,userName:String,userImage:String,userNumber: String){
        sesi.saveToPreference(UID,uiduser)
        sesi.saveToPreference(USER_NAME, userName)
        sesi.saveToPreference(USER_IMAGE,userImage)
        sesi.saveToPreference(USER_NUMBER, userNumber)
    }
    fun setUserNameUser(userName: String){
        sesi.saveToPreference(USER_NAME,userName)
    }

    fun setUserEmail(email : String){
        sesi.saveToPreference(USER_EMAIL, email)
    }

    fun getNameUser() = sesi.getFromPreference(USER_NAME)
    fun getImageUser() = sesi.getFromPreference(USER_IMAGE)

    fun getTokenUser() = sesi.getFromPreference(ACCESS_TOKEN)

    fun getUidUser() = sesi.getFromPreference(UID)

    fun getUserNumber() = sesi.getFromPreference(USER_NUMBER)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()
}