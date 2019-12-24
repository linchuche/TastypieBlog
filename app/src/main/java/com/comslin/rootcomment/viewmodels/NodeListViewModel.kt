package com.comslin.rootcomment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.http.NodeService
import com.comslin.rootcomment.repository.NetworkState
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by linchao on 2019/12/12.
 */
class NodeListViewModel internal constructor() : BaseViewModel() {
    //    private val
    public val nodesLiveData = MutableLiveData<BasePageBean<NodeBean>>()
    public val networkState = MutableLiveData<NetworkState>()
//    val nodePageList: LiveData<PagedList<NodeBean>> =
//    val networkState: LiveData<NetworkState>
    // represents the refresh status to show to the user. Separate from networkState, this
    // value is importantly only when refresh is requested.
//    val refreshState: LiveData<NetworkState>

    init {
//        viewModelScope.launch {
//            nodesLiveData.value = NodeService.create().nodeGet().content.data
//        }
    }

    public fun getNodeList() {
        networkState.postValue(NetworkState.LOADING)
        NodeService.create().nodeGet()
            .enqueue(object : Callback<BasePageBean<NodeBean>> {
                override fun onResponse(
                    call: Call<BasePageBean<NodeBean>>,
                    response: Response<BasePageBean<NodeBean>>
                ) {
                    nodesLiveData.postValue(response.body())
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