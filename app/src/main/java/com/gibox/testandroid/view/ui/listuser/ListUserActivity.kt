/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.view.ui.listuser

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem
import com.gibox.testandroid.databinding.ActivityListUserBinding
import com.gibox.testandroid.view.ui.listuser.adapter.UserAdapter
import com.gibox.testandroid.view.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class ListUserActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListUserBinding.inflate(layoutInflater) }

    private val viewModel:MainViewModel by viewModel<MainViewModel>()
    private var page:Int = 1
    private var isLoadMore : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initAdapter()
        observeViewModel()
        initAction()
        viewModel.requestListUser(page)
    }

    private lateinit var adapter:UserAdapter
    private var listUser:ArrayList<DataItem> = arrayListOf()
    private fun initAdapter() {
        adapter = UserAdapter(listUser)
        binding.rvUser.adapter = adapter

    }

    private fun initAction(){
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = true
            page = 1
            viewModel.requestListUser(page)
        }

        binding.rvUser.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(!recyclerView.canScrollVertically(1)){
                    if(!isLoadMore){
                        isLoadMore = true
                        page++
                        viewModel.requestListUser(page)
                    }
                }
            }
        })
    }

    private fun observeViewModel() {
        viewModel.isLoadingRequestListUser.observe(this){
            if (it){
                binding.tvEmpty.visibility = View.GONE
                if (page == 1){
                    binding.pb.visibility = View.VISIBLE
                    binding.rvUser.visibility = View.GONE
                }else {
                    binding.pb.visibility = View.GONE
                    binding.rvUser.visibility = View.VISIBLE
                }
            }else{
                isLoadMore = false
                binding.pb.visibility = View.GONE
                binding.rvUser.visibility = View.VISIBLE
                binding.swipeRefresh.isRefreshing = false
            }
        }

        viewModel.dataRequestListUser.observe(this) {
            isLoadMore = false
            if(it.page != null){
                page = it.page
            }

            if (it.data != null){
                listUser.addAll(it.data)
                adapter.notifyDataSetChanged()
            }

            if (listUser.isNotEmpty()){
                binding.tvEmpty.visibility = View.GONE
            }
        }

        viewModel.isErrorRequestListUser.observe(this){
            isLoadMore = false
            if (!it.isNullOrEmpty()){
                val snackBar = Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT)
                snackBar.show()
            }
        }
    }
}