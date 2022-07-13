/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.di

import androidx.paging.ExperimentalPagingApi
import com.gibox.testandroid.core.data.auth.source.AuthRepository
import com.gibox.testandroid.core.data.auth.source.remote.AuthRemoteDataSource
import com.gibox.testandroid.core.domain.auth.repository.IAuthRepository
import org.koin.dsl.module

@ExperimentalPagingApi
val repositoryModule = module {

    single { AuthRemoteDataSource(authService = get()) }
    single<IAuthRepository> { AuthRepository(authRemoteDataSource = get()) }

}