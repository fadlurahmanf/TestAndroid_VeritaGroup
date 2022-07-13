/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.data.persistences.mapper.auth

import com.gibox.testandroid.core.data.auth.source.remote.response.LoginResponse
import com.gibox.testandroid.core.domain.auth.model.LoginEntityDomain

object AuthDataMapper {
    fun mapResponseToDomain(input:LoginResponse):LoginEntityDomain{
        val loginEntityDomain =LoginEntityDomain(
            token = input.token,
            page = input.page
        )
        return loginEntityDomain
    }
}