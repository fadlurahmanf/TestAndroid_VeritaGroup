/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.listuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gibox.testandroid.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListUserBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}