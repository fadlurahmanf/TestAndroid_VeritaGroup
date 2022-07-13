/*
 * Created by Muhamad Syafii
 * Wednesday, 26/1/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.session

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SessionViewModel(private val sessionRepository: SessionRepository): ViewModel() {
    private val _uid = MutableLiveData<String>()
    private val _accessToken = MutableLiveData<String>()
    private val _tokenType = MutableLiveData<String>()
    private val _userName = MutableLiveData<String>()
    private val _userImage = MutableLiveData<String>()

    val uid = _uid
    val accessToken = _accessToken
    val tokenType = _tokenType
    val userName = _userName
    val userImage = _userImage

    fun setUserNameUser(name:String){
        sessionRepository.setUserNameUser(name)
    }

    fun getUidUser(){
        _uid.postValue(sessionRepository.getUidUser())
    }

    fun getTokenUser(){
        _accessToken.postValue(sessionRepository.getTokenUser())
    }
    fun getAvatarUser(){
        _userImage.postValue(sessionRepository.getImageUser())
    }
    fun getUserNameUser(){
        _userName.postValue(sessionRepository.getNameUser())
    }

    fun logout(){
        sessionRepository.logoutUser()
        _uid.postValue(null)
        _accessToken.postValue(null)
        _userImage.postValue(null)
        _userName.postValue(null)
    }
}