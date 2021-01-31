package com.cc.mvvm.ext

import com.cc.mvvm.net.ResultData


/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
inline fun <T : Any> ResultData<T>.checkResult(
    crossinline onSuccess: (T) -> Unit,
    crossinline onError: (String?) -> Unit
) {
    if (this is ResultData.Success) {
        onSuccess(data)
    } else if (this is ResultData.Error) {
        onError(exception.message)
    }
}

inline fun <T : Any> ResultData<T>.checkSuccess(success: (T) -> Unit) {
    if (this is ResultData.Success) {
        success(data)
    }
}