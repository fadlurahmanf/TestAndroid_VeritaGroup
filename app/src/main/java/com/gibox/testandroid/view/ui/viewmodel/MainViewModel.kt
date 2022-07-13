/*
 * Created by Muhamad Syafii
 * , 5/4/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem
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
        //TODO : Put here your code

    }

}