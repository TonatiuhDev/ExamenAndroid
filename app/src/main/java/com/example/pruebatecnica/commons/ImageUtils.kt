package com.example.pruebatecnica.commons

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.setImage(image: String) {
    Glide.with(context).load(image)
        .centerCrop()
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .dontAnimate()
        .into(this)
}