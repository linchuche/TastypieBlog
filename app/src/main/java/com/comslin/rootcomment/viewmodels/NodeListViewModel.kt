package com.comslin.rootcomment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.http.NodeService
import kotlinx.coroutines.launch

/**
 * Created by linchao on 2019/12/12.
 */
class NodeListViewModel internal constructor() : BaseViewModel() {
    //    private val
    public val nodesLiveData = MutableLiveData<BasePageBean>()

    init {
//        viewModelScope.launch {
//            nodesLiveData.value = NodeService.create().nodeGet().content.data
//        }
    }

    public fun getNodeList() {
        request({ NodeService.create().nodeGet() }, {
            nodesLiveData.value = it.data
        })
    }

}