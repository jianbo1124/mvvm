package com.cc.mvvm

import android.app.Application
import android.content.Context
import com.cc.mvvm.koin.appModule
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class MyApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        sContext = this

    }

    override fun onCreate() {
        super.onCreate()

        MMKV.initialize(this)


        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

    companion object {
        @JvmStatic
        var sContext: MyApplication by Delegates.notNull()
            private set
    }
}