package com.comslin.rootcomment.app

import android.app.Activity
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.comslin.rootcomment.viewmodels.BaseViewModel

/**
 * Created by linchao on 2019/12/15.
 */
abstract class BaseActivity : ComponentActivity() {
    /**
     * 初始化默认的viewModel
     */
    inline fun <reified VM : BaseViewModel> createViewModel(): VM {
        val mViewModel = ViewModelProvider(this)[VM::class.java]
        return mViewModel
    }

    open fun toastMessage(throwable: Throwable) {
        if (!TextUtils.isEmpty(throwable.message)) {
            Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
        }
    }

    open fun onError(throwable: Throwable) {

    }
}