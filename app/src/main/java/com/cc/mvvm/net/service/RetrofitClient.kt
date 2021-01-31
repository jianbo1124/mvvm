package com.cc.mvvm.net.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import kotlin.properties.Delegates

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class RetrofitClient {

    /**
     * 创建okhttp相关对象
     */
    private var okHttpClient: OkHttpClient by Delegates.notNull()

    /**
     * 创建Retrofit相关对象
     */
    private var retrofit: Retrofit by Delegates.notNull()

    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the `service` interface.
     */
    fun <T> create(service: Class<T>?): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit.create(service)
    }

    companion object {
        private const val TAG = "RequestRetrofit"
        const val TIME_OUT = 10L
    }

    init {
        /**
         * 创建okhttp相关对象
         */


        val loggingInterceptor = HttpLoggingInterceptor(TAG)
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO)
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .addInterceptor(loggingInterceptor) //Log
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS) //超时时间
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)

            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/") //BaseUrl
            .client(okHttpClient) //请求的网络框架
            .addConverterFactory(GsonConverterFactory.create()) //解析数据格式
            .build()
    }
}