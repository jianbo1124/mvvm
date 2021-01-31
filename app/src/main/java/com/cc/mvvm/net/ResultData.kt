package com.cc.mvvm.net

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
sealed class ResultData<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class SuccessList<out T : Any>(val data: List<T>) : ResultData<List<T>>()
    data class Error(val exception: Exception) : ResultData<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is SuccessList<*> -> "Success[data=$data]"
        }
    }
}