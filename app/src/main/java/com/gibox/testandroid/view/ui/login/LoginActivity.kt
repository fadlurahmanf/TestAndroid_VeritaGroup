/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.gibox.testandroid.core.data.auth.source.remote.request.LoginRequest
import com.gibox.testandroid.databinding.ActivityLoginBinding
import com.gibox.testandroid.view.ui.dialog.LoadingDialog
import com.gibox.testandroid.view.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.IOException
import java.lang.RuntimeException

class LoginActivity : AppCompatActivity() {


    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    private val mainViewModel:MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listenEditText()
        initAction()
        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.isLoadingRequestLogin.observe(this) {
            if (it) {
                showLoading()
            } else {
                dismissLoading()
            }
        }

        mainViewModel.isErrorRequestLogin.observe(this){
            if (!it.isNullOrEmpty()){
                val snackBar = Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
                snackBar.show()
            }
        }

        mainViewModel.dataRequestLogin.observe(this){
            if (it.token?.isNullOrEmpty() == false && it.page != null){
                val snackBar = Snackbar.make(binding.root, "success", Snackbar.LENGTH_LONG)
                snackBar.show()
            }
        }
    }

    private var loadingDialog:LoadingDialog?=null
    private fun showLoading(){
        dismissLoading()
        if(loadingDialog == null){
            loadingDialog = LoadingDialog()
            loadingDialog?.show(supportFragmentManager, LoadingDialog::class.java.simpleName)
        }
    }

    private fun dismissLoading(){
        if (loadingDialog != null){
            loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

    private fun listenEditText() {
        binding.etEmail.doOnTextChanged { text, start, before, count ->
            if (count <= 0){
                binding.etlEmail.error = "Field is required"
            }else{
                binding.etlEmail.error = null
            }
        }

        binding.etPassword.doOnTextChanged { text, start, before, count ->
            if (count <= 0) {
                binding.etlPassword.error = "Field is required"
            } else {
                binding.etPassword.error = null
            }
        }
    }

    private fun initAction() {
        binding.btnLogin.setOnClickListener {
            if(binding.etPassword.text?.isNotEmpty() == true && binding.etEmail.text?.isNotEmpty() == true){
                mainViewModel.requestLogin(
                    LoginRequest(
                    email = binding.etEmail.text?.toString()?:"",
                    password = binding.etPassword.text?.toString()?:""
                )
                )
            }
        }
    }
}