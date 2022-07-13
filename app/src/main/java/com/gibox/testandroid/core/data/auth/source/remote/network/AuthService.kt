/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.data.auth.source.remote.network

import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.core.data.auth.source.remote.response.LoginResponse
import com.gibox.testandroid.core.data.auth.source.remote.response.ResponseListUser
import retrofit2.http.*

interface AuthService {
    @POST("put end point here")
    suspend fun authenticate(@Body body: LoginRequest?): LoginResponse

    @GET("put end point here")
    suspend fun dataListUser(
        @Query("page") Page: Int
    ):ResponseListUser
}