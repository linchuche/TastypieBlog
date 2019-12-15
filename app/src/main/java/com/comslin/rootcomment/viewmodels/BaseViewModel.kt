package com.comslin.rootcomment.viewmodels

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comslin.rootcomment.bean.DataBean
import com.comslin.rootcomment.bean.RootResponse
import com.comslin.rootcomment.http.ExceptionHandle
import kotlinx.coroutines.*

/**
 * Created by linchao on 2019/12/15.
 */
abstract class BaseViewModel : ViewModel() {


    fun <T> request(
        request: suspend CoroutineScope.() -> RootResponse<T>,
        success: ((info: DataBean<T>) -> Unit)
    ) {
        runOnIo(request, success, {})
    }

    /**
     * 用来包裹协程的错误信息
     */
    private suspend fun <T> tryCatch(tryBlock: suspend CoroutineScope.() -> RootResponse<T>): RootResponse<T> {
        return coroutineScope {
            try {
                return@coroutineScope tryBlock()
            } catch (e: Throwable) {
                e.printStackTrace()
                var message = ExceptionHandle.handleException(e)?.message
                if (TextUtils.isEmpty(message)) {
                    message = "未知异常"
                }
                val dataBean = DataBean<T>(code = -1, message = message, data = null)

                val response = RootResponse<T>(content = dataBean, code = -1)

                return@coroutineScope response
            }
        }
    }

    private fun <T> runOnIo(
        request: suspend CoroutineScope.() -> RootResponse<T>,
        success: ((info: DataBean<T>) -> Unit),
        error: ((info: RootResponse<T>) -> Unit)
    ) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                tryCatch(request)
            }
            if (response.code == 1) {
                success.invoke(response.content)
            } else {
//                if (response.data != null && !TextUtils.isEmpty(response.data.message)) {
//                    mException.value = Throwable(response.data.message)
//                } else {
//                    mException.value = Throwable("未知异常")
//                }
                error.invoke(response)
            }
        }
    }

}