package com.cc.mvvm.main.adapter

import com.cc.mvvm.room.dto.AppDTO
import com.cc.mvvm.utils.GlideLoader
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class MainBannerAdapter(mData: List<AppDTO> = arrayListOf()) :
    BannerImageAdapter<AppDTO>(mData) {
    override fun onBindView(
        holder: BannerImageHolder,
        data: AppDTO,
        position: Int,
        size: Int
    ) {
        GlideLoader.instance.loadUrlImage(holder.imageView, data.imagePath?:"")
    }
}