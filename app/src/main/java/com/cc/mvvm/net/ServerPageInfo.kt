package com.cc.mvvm.net

import java.io.Serializable

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class ServerPageInfo<T> : Serializable {

    var list: List<T> = arrayListOf()
        private set

    fun setList(list: List<T>) {
        this.list = list
    }
}