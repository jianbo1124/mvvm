package com.cc.mvvm.koin


import com.cc.mvvm.MyApplication
import com.cc.mvvm.main.MainViewModel
import com.cc.mvvm.net.repository.MainRepository
import com.cc.mvvm.net.service.HttpService
import com.cc.mvvm.net.service.RetrofitClient
import com.cc.mvvm.room.AppDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }

}


val repositoryModule = module {
    single { RetrofitClient().create(HttpService::class.java) }
    single { AppDatabase.getInstance(MyApplication.sContext.applicationContext).appDAO() }
    single { MainRepository(get(), get()) }
}


val appModule = listOf(viewModelModule, repositoryModule)