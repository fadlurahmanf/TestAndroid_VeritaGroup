/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.di

import com.gibox.testandroid.core.session.SessionManager
import com.gibox.testandroid.core.session.SessionRepository
import org.koin.dsl.module

val sessionModule = module {
    single {
        SessionManager(get())
    }
    single {
        SessionRepository(sesi = get())
    }
}