package com.gibox.testandroid.view.ui.listuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gibox.testandroid.R
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem

class UserAdapter(var list:ArrayList<DataItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val iv : ImageView = view.findViewById(R.id.iv_profile)
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvEmail: TextView = view.findViewById(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        val mHolder = holder as ViewHolder
        Glide.with(mHolder.iv).load(item.avatar)
            .centerCrop()
            .into(mHolder.iv)

        mHolder.tvName.text = "${item.firstName} ${item.lastName}"
        mHolder.tvEmail.text = item.email?:""
    }

    override fun getItemCount(): Int {
        return list.size
    }
}