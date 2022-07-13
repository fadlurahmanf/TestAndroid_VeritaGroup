/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.domain.auth.usecase

import androidx.paging.PagingData
import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem
import com.gibox.testandroid.core.data.vo.Resource
import com.gibox.testandroid.core.domain.auth.model.LoginEntityDomain
import com.gibox.testandroid.core.domain.auth.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow

class AuthInteractor(private val authRepository: IAuthRepository):AuthUseCase {
    override fun doLogin(dataLogin: LoginRequest): Flow<Resource<LoginEntityDomain>> {
        return authRepository.doLogin(dataLogin)
    }

    override fun getUserList(): Flow<PagingData<DataItem>> {
        return authRepository.getUserList()
    }
}