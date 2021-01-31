package com.cc.mvvm.net.repository

import com.cc.mvvm.net.BaseRepository
import com.cc.mvvm.net.ResultData
import com.cc.mvvm.net.service.HttpService
import com.cc.mvvm.room.dao.AppDAO
import com.cc.mvvm.room.dto.AppDTO

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class MainRepository(private val appDAO: AppDAO, private val service: HttpService) :
    BaseRepository() {
    /**
     * 获取banner
     */
    suspend fun getBanner(): ResultData<List<AppDTO>> {
        return safeApiCall(call = {
            var response = service.getBanner()
            executeResponse(response)
        })
    }

    suspend fun getLocalBanner(): List<AppDTO> {
        return appDAO.queryBanner() ?: emptyList()
    }

    suspend fun saveToDB(data: List<AppDTO>?) {
        if (data.isNullOrEmpty()) return
        appDAO.addBannerList(data)
    }
}