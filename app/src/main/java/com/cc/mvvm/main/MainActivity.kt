package com.cc.mvvm.main

import android.widget.Toast
import com.cc.mvvm.R
import com.cc.mvvm.base.BaseVMActivity
import com.cc.mvvm.databinding.ActivityMainBinding
import com.cc.mvvm.main.adapter.MainBannerAdapter
import com.cc.mvvm.utils.Convert
import com.youth.banner.indicator.CircleIndicator
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class MainActivity : BaseVMActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val mainViewModel by viewModel<MainViewModel>()
    private val mainBannerAdapter by lazy { MainBannerAdapter() }
    override fun initView() {
        binding.run {
            viewModel = mainViewModel
            bannerAdapter = mainBannerAdapter
            bannerGuideContent.apply {
                indicator = CircleIndicator(context)
                addBannerLifecycleObserver(this@MainActivity)
            }


            write.setOnClickListener {
                mainViewModel.saveToDB()
            }
            read.setOnClickListener {
                mainViewModel.readFromDB()
            }


        }

    }

    override fun initData() {
        mainViewModel.loadBanner()
    }

    override fun startObserve() {
        mainViewModel.apply {
            uiState.observe(this@MainActivity) {

                it.isSuccess?.let { data ->
                    binding.bannerGuideContent.setDatas(data)
                }

                it.isError?.let {

                }


            }

            saveState.observe(this@MainActivity) {
                it.isSuccess?.let { data ->
                    Toast.makeText(this@MainActivity, data, Toast.LENGTH_LONG).show()
                }
            }
            localBanner.observe(this@MainActivity) {
                it.isSuccess?.let { data ->
                    var value = Convert.toJson(data)
                    binding.rvJson.bindJson(value )
                }
            }

        }
    }

}