package com.cc.mvvm.net.service


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val requestBuilder: Request.Builder = original.newBuilder()
                .header("token","token")
        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}