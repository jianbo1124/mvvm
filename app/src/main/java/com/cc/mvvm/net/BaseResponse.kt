package com.cc.mvvm.net

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
data class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)