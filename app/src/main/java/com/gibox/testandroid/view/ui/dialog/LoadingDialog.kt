package com.gibox.testandroid.view.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.gibox.testandroid.databinding.DialogLoadingBinding

class LoadingDialog:DialogFragment() {

    private lateinit var _binding:DialogLoadingBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogLoadingBinding.inflate(layoutInflater)
        return binding.root
    }

}