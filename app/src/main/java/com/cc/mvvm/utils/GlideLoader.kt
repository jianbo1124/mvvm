package com.cc.mvvm.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.cc.mvvm.MyApplication
import com.cc.mvvm.R
import java.io.File

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class GlideLoader private constructor() {

    companion object {
        val instance = GlideHolder.holder
    }

    private object GlideHolder {
        val holder = GlideLoader()
    }

    fun loadImage(imageView: ImageView, imgPath: String) {
        Glide.with(MyApplication.sContext)
            .asBitmap()
            .load(File(imgPath)).placeholder(R.drawable.ic_baseline_broken_image)
            .error(R.drawable.ic_baseline_broken_image)
            .fallback(R.drawable.ic_baseline_broken_image)
            .into(imageView)
    }

    fun loadUrlImage(imageView: ImageView, url: String) {
        Glide.with(MyApplication.sContext)
            .asBitmap()
            .load(url).placeholder(R.drawable.ic_baseline_broken_image)
            .error(R.drawable.ic_baseline_broken_image)
            .fallback(R.drawable.ic_baseline_broken_image)
            .into(imageView)
    }

}