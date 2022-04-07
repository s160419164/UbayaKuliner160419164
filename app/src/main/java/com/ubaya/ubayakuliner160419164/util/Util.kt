package com.ubaya.ubayakuliner160419164.util

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.ubayakuliner160419164.R

import java.lang.Exception

fun ImageView.loadImage(url: String?) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {

            }
            override fun onError(e: Exception?) {
            }
        })
}