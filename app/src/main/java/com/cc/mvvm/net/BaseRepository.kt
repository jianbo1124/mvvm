package com.cc.mvvm.net


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2021/1/31
 *    @Desc   :
 */
open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return call.invoke()
    }

    /**
     * 捕获异常
     */
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> ResultData<T>,
        errorMessage: String
    ): ResultData<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            ResultData.Error(IOException(errorMessage, e))
        }
    }

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> ResultData<T>
    ): ResultData<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            ResultData.Error(IOException(e))
        }
    }

    suspend fun <T : Any> executeResponse(
        response: BaseResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): ResultData<T> {
        return coroutineScope {
            if (response.errorCode == 0) {
                successBlock?.let { it() }
                ResultData.Success(response.data)
            } else {
                errorBlock?.let { it() }
                var msg = response.errorMsg
                if (msg.isNullOrBlank()) {
                    msg = "请求异常"
                }
                ResultData.Error(IOException(msg))
            }
        }
    }

    suspend fun <T : Any> executeResponseWithPage(
        response: BaseResponse<ServerPageInfo<T>>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): ResultData<List<T>> {
        return coroutineScope {
            if (response.errorCode == 0) {
                successBlock?.let { it() }
                ResultData.SuccessList(response.data.list)
            } else {
                errorBlock?.let { it() }
                var msg = response.errorMsg
                if (msg.isNullOrBlank()) {
                    msg = "请求异常"
                }
                ResultData.Error(IOException(msg))
            }
        }
    }

}