package com.cc.mvvm.net.service


import com.cc.mvvm.net.BaseResponse
import com.cc.mvvm.room.dto.AppDTO
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Streaming
import retrofit2.http.Url


/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
interface HttpService {


    //下载图片
    @Streaming
    @GET
    fun downloadPicWithUrl(@Url url: String?): Call<ResponseBody>

    /**
     *
     */
    @POST("banner/json")
    suspend fun getBanner(): BaseResponse<List<AppDTO>>


}