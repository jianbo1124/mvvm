package com.cc.mvvm.room.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
@Entity(tableName = "APP")
data class AppDTO(
    val desc: String? = "",
    val id: Int = 0,
    val imagePath: String? = "",
    val isVisible: Int = 0,
    val order: Int = 0,
    val title: String? = null,
    val type: Int = 0,
    val url: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var bannerID: Long = 0
}