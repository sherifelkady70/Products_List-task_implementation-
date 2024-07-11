package com.route.products_listtask_implementation.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import androidx.databinding.BindingAdapter

class BindingAdapter {
    companion object {
        @BindingAdapter("app:image_url")
        fun bindImage(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .into(imageView)
        }

    }
}