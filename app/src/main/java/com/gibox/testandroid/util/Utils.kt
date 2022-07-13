/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gibox.testandroid.R


/* Toast */
fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/* Hide Keyboard */
fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = currentFocus
    if (view != null) {
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

/* Open Activity from Activity or Fragment */
fun <T> Fragment.openActivity(destination: Class<T>) {
    val intent = Intent(requireContext(), destination)
    startActivity(intent)
}

fun <T> Activity.openActivity(destination: Class<T>) {
    val intent = Intent(this, destination)
    startActivity(intent)
}

/*Add for close activity*/
fun Activity.closeActivity(){
    hideKeyboard()
    finish()
}

/*Load image use Glide library*/
fun ImageView.loadImage(value : String){
    Glide.with(this)
        .load(value)
        .apply(RequestOptions().override(500,500))
        .centerCrop()
        .into(this)
}


