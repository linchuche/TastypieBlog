package com.comslin.rootcomment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.http.NodeApi
import com.comslin.rootcomment.repository.NetworkState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by linchao on 2019/12/12.
 */
class NodeListViewModel internal constructor() : BaseViewModel() {
    //    private val
    public val nodeListResult = MutableLiveData<BasePageBean<NodeBean>>()
    public val nodes: LiveData<List<NodeBean>> =
        Transformations.map(nodeListResult) { it ->
            it.objects
        }
    public val networkState = MutableLiveData<NetworkState>()

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }

    init {
        loadMoreNodeList()
    }

    private var lastRequestedPage = 0
    private val pageSize = 20
    public fun refreshNodeList() {
        lastRequestedPage = 0;
        loadMoreNodeList()
    }

    fun listScrolled(visibleItemCount: Int, lastVisibleItemPosition: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount) {
//            loadMoreNodeList()
        }
    }

    public fun loadMoreNodeList() {
        networkState.postValue(NetworkState.LOADING)
        NodeApi.create().nodeGet(lastRequestedPage * pageSize)
            .enqueue(object : Callback<BasePageBean<NodeBean>> {
                override fun onResponse(
                    call: Call<BasePageBean<NodeBean>>,
                    response: Response<BasePageBean<NodeBean>>
                ) {
                    lastRequestedPage++
                    nodeListResult.postValue(response.body())
                    networkState.postValue(NetworkState.LOADED)
                }

                override fun onFailure(call: Call<BasePageBean<NodeBean>>, t: Throwable) {
                    // retrofit calls this on main thread so safe to call set value
                    networkState.value = NetworkState.error(t.message)
                    networkState.postValue(NetworkState.LOADED)
                }
            }
            )

    }

}