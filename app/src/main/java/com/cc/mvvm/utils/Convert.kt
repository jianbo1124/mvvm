package com.cc.mvvm.utils

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.JsonReader
import java.io.Reader
import java.lang.reflect.Type

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class Convert private constructor() {
    companion object {
        private val instance = GsonHolder.holder

        @Throws(JsonIOException::class, JsonSyntaxException::class)
        fun <T> fromJson(json: String?, type: Class<T>?): T {
            return instance.fromJson(json, type)
        }

        fun <T> fromJson(json: String?, type: Type?): T {
            return instance.fromJson(json, type)
        }

        @Throws(JsonIOException::class, JsonSyntaxException::class)
        fun <T> fromJson(reader: JsonReader?, typeOfT: Type?): T {
            return instance.fromJson(reader, typeOfT)
        }

        @Throws(JsonSyntaxException::class, JsonIOException::class)
        fun <T> fromJson(json: Reader?, classOfT: Class<T>?): T {
            return instance.fromJson(json, classOfT)
        }

        @Throws(JsonIOException::class, JsonSyntaxException::class)
        fun <T> fromJson(json: Reader?, typeOfT: Type?): T {
            return instance.fromJson(json, typeOfT)
        }

        fun toJson(src: Any?): String {
            return instance.toJson(src)
        }

        fun toJson(src: Any?, typeOfSrc: Type?): String {
            return instance.toJson(src, typeOfSrc)
        }


    }

    private object GsonHolder {
        val holder = Gson()
    }


}