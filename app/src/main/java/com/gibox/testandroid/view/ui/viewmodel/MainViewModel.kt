/*
 * Created by Muhamad Syafii
 * , 5/4/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem
import com.gibox.testandroid.core.data.auth.source.remote.response.ResponseListUser
import com.gibox.testandroid.core.data.vo.Resource
import com.gibox.testandroid.core.domain.auth.model.LoginEntityDomain
import com.gibox.testandroid.core.domain.auth.usecase.AuthUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(private val authUseCase:AuthUseCase):ViewModel() {

    private val _isErrorRequestLogin = MutableLiveData<String>()
    private val _dataRequestLogin = MutableLiveData<LoginEntityDomain>()
    private val _isLoadingRequestLogin = MutableLiveData<Boolean>()

    val isErrorRequestLogin = _isErrorRequestLogin
    val dataRequestLogin = _dataRequestLogin
    val isLoadingRequestLogin = _isLoadingRequestLogin

    fun requestLogin(loginRequest:LoginRequest){
        viewModelScope.launch {
            _isLoadingRequestLogin.value = true
            authUseCase.doLogin(loginRequest).collect {
                when(it){
                    is Resource.Success -> {
                        _isLoadingRequestLogin.value = false
                        _isErrorRequestLogin.value = ""
                        _dataRequestLogin.value = it.data
                    }
                    is Resource.Loading -> {
                        _isLoadingRequestLogin.value = true
                        _dataRequestLogin.value = LoginEntityDomain(
                            token = null,
                            page = null
                        )
                        _isErrorRequestLogin.value = ""
                    }
                    is Resource.Error -> {
                        _isLoadingRequestLogin.value = false
                        _isErrorRequestLogin.value = it.message
                        _dataRequestLogin.value = LoginEntityDomain(
                            token = null,
                            page = null
                        )
                    }
                }
            }
        }
    }

    private val _isErrorRequestListUser = MutableLiveData<String>()
    private val _dataRequestListUser = MutableLiveData<ResponseListUser>()
    private val _isLoadingRequestListUser = MutableLiveData<Boolean>()

    val isErrorRequestListUser = _isErrorRequestListUser
    val dataRequestListUser = _dataRequestListUser
    val isLoadingRequestListUser = _isLoadingRequestListUser

    fun requestListUser(page:Int){
        viewModelScope.launch {
            _isLoadingRequestListUser.value = true
            authUseCase.getUserList(page).collect {
                when(it){
                    is Resource.Success -> {
                        _isLoadingRequestListUser.value = false
                        _dataRequestListUser.value = it.data
                        _isErrorRequestListUser.value = ""
                    }
                    is Resource.Loading -> {
                        _isLoadingRequestListUser.value = true
                        _isErrorRequestListUser.value = ""
                        _dataRequestListUser.value = ResponseListUser(
                            page = null,
                            data = null,
                            total = null
                        )
                    }
                    is Resource.Error -> {
                        _isLoadingRequestListUser.value = false
                        _isErrorRequestListUser.value = ""
                        _dataRequestListUser.value = ResponseListUser(
                            page = null,
                            total = null,
                            data = null
                        )
                    }
                }
            }
        }
    }

}