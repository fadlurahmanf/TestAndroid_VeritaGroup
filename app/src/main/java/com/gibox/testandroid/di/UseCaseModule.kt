/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.di

import com.gibox.testandroid.core.domain.auth.usecase.AuthInteractor
import com.gibox.testandroid.core.domain.auth.usecase.AuthUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<AuthUseCase>{ AuthInteractor(get()) }
}