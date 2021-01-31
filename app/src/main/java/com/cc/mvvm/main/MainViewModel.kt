package com.cc.mvvm.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cc.mvvm.base.BaseViewModel
import com.cc.mvvm.ext.checkResult
import com.cc.mvvm.net.repository.MainRepository
import com.cc.mvvm.room.dto.AppDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    private val mUIState = MutableLiveData<UiState<List<AppDTO>>>()
    val uiState: LiveData<UiState<List<AppDTO>>>
        get() = mUIState

    private val mSaveState = MutableLiveData<UiState<String>>()
    val saveState: LiveData<UiState<String>>
        get() = mSaveState

    private val mLocalBanner = MutableLiveData<UiState<List<AppDTO>>>()
    val localBanner: LiveData<UiState<List<AppDTO>>>
        get() = mLocalBanner

    fun loadBanner() {

        viewModelScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) { mUIState.value = UiState(isLoading = true) }
            var result = repository.getBanner()
            withContext(Dispatchers.Main) {

                result.checkResult(
                    onSuccess = {
                        mUIState.value = UiState(isSuccess = it)
                    },
                    onError = {
                        mUIState.value = UiState(isError = it)
                    })
            }

        }
    }

    fun saveToDB() {
        viewModelScope.launch(Dispatchers.Default) {
            repository.saveToDB(mUIState.value?.isSuccess)
            withContext(Dispatchers.Main) { mSaveState.value = UiState(isSuccess = "写入成功") }
        }

    }

    fun readFromDB() {
        viewModelScope.launch(Dispatchers.Default) {
            var result = repository.getLocalBanner()
            withContext(Dispatchers.Main) { mLocalBanner.value = UiState(isSuccess = result) }
        }

    }


}