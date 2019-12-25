package com.comslin.rootcomment.http

import android.util.Log
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by linchao on 2019/12/10.
 */
interface NodeApi {
    companion object {
        const val BASE_URL = "http://120.76.58.98:8000/coretree/api/v1/"
        fun create(): NodeApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("API", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            val retrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(NodeApi::class.java);
        }

    }

    @GET("node")
    fun nodeGet(@Query("offset") offset: Int): Call<BasePageBean<NodeBean>>

    @GET("node")
    suspend fun nodePost()

}