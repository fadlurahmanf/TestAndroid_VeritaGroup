/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.gibox.testandroid.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

@ExperimentalPagingApi
class AppController : Application() {
    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.IS_RELEASE){
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AppController)
            modules(listOf(
                networkModule,
                repositoryModule,
                sessionModule,
                useCaseModule,
                viewModelModule
            ))
        }

    }


    //get from cpp external
    private external fun baseUrl() : String


    //for get method if u needed
    fun baseURL() : String = baseUrl()

}