/*
 * Created by Muhamad Syafii
 * Thursday, 27/1/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gibox.testandroid.R
import com.gibox.testandroid.util.openActivity
import com.gibox.testandroid.view.ui.login.LoginActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
@ExperimentalCoroutinesApi
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            openActivity(LoginActivity::class.java)
            finish()
        }, 1500L)
    }
}