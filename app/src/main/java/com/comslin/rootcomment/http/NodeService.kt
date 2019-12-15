package com.comslin.rootcomment.http

import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.bean.RootResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by linchao on 2019/12/10.
 */
interface NodeService {
    companion object {
        const val BASE_URL = "http://120.76.58.98:8000/coretree/api/"
        fun create(): NodeService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://120.76.58.98:8000/coretree/api/")
                .build()

            return retrofit.create(NodeService::class.java);
        }

    }

    @GET("node")
    suspend fun nodeGet(): RootResponse<BasePageBean>

    @GET("node")
    suspend fun nodePost()

}