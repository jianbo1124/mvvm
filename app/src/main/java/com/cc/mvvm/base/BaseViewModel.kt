package com.cc.mvvm.base

import androidx.lifecycle.ViewModel

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
open class BaseViewModel : ViewModel() {

    open class UiState<T>(
        val isLoading: Boolean = false,
        val isSuccess: T? = null,
        val isError: String? = null
    )

}