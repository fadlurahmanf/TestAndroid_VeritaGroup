/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.di

import androidx.paging.ExperimentalPagingApi
import com.gibox.testandroid.AppController
import com.gibox.testandroid.BuildConfig
import com.gibox.testandroid.core.data.auth.source.remote.network.AuthService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import org.koin.core.qualifier.named
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@ExperimentalPagingApi
val networkModule = module {
    single {
        OkHttpClient.Builder().apply {
            if (!BuildConfig.IS_RELEASE) addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single(named("Base")) {
        return@single Retrofit.Builder()
            .baseUrl(AppController().baseURL())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()

    }

    single{
        get<Retrofit>(named("Base")).create(AuthService::class.java)
    }

}

