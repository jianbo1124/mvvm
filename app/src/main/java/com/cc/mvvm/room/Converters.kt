package com.cc.mvvm.room

import androidx.room.TypeConverter
import com.cc.mvvm.utils.Convert
import com.google.gson.reflect.TypeToken


/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :转换器
 */
class Converters {

    @TypeConverter
    fun fromList(mList: List<String>?): String? {
        return if (mList.isNullOrEmpty()) "" else Convert.toJson(mList)
    }

    @TypeConverter
    fun jsonToList(value: String?): List<String>? {
        if (value.isNullOrEmpty()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<String>>() {
        }.type
        return Convert.fromJson(value, listType)
    }

}

