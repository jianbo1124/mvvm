package com.cc.mvvm.room.dao

import androidx.room.*
import com.cc.mvvm.room.dto.AppDTO

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
@Dao
interface AppDAO {

    @Query("select *  from APP ")
    suspend fun queryBanner(): List<AppDTO>?

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBannerList(data: List<AppDTO>)

}