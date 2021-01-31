package com.cc.mvvm.binding

import androidx.databinding.BindingAdapter
import com.cc.mvvm.main.adapter.MainBannerAdapter
import com.youth.banner.Banner

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
@BindingAdapter(value = ["bannerAdapter"])
fun Banner<*, MainBannerAdapter>.bannerAdapter(adapter: MainBannerAdapter) {
    setAdapter(adapter)
}