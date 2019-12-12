package com.comslin.rootcomment

import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.recyclerview.widget.AsyncListUtil
import com.comslin.rootcomment.bean.BaseBean
import com.comslin.rootcomment.databinding.ActivityMainBinding
import com.comslin.rootcomment.http.NodeService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val nodeService = NodeService.create();

        val bean: LiveData<BaseBean> = liveData {
            val data = nodeService.nodeGet()
            emit(data)
        }
        binding.user = User("test", bean.toString())

        lifecycle.addObserver(MyObserver())
    }

    class MyObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun connectListener() {
            Log.d("tag", "ON_RESUME")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun disconnectListener() {
            Log.d("tag", "pause")

        }
    }

//    fun <T> request(
//        request: suspend CoroutineScope.() -> BaseBean,
//        success: ((info: BaseBean.MetaBean) -> Unit)
//    ) {
//        runOnIo(request, success, {})
//    }
}
