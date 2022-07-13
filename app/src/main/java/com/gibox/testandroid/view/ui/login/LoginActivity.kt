/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.databinding.ActivityLoginBinding
import com.gibox.testandroid.util.constant.FIELD_REQUIRED
import com.gibox.testandroid.util.hideKeyboard
import com.gibox.testandroid.util.openActivity
import com.gibox.testandroid.util.showToast
import com.gibox.testandroid.view.ui.viewmodel.MainViewModel
import com.gibox.testandroid.view.ui.listuser.ListUserActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {


    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    private val mainViewModel:MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}