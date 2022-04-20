package com.example.elmenus.domain.usecase

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.elmenus.R
import com.example.elmenus.base.BaseApplication

typealias LoadPhoto = LoadPhotoUseCase

class LoadPhotoUseCase {

    operator fun invoke(imageView: ImageView, url: String,context:Context) =
        Glide.with(imageView).load(url)
            .placeholder(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.cloche
                )
            ).into(imageView)



}