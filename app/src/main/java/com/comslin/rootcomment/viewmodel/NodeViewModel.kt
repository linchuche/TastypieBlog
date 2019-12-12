package com.comslin.rootcomment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comslin.rootcomment.http.NodeService
import kotlinx.coroutines.launch

/**
 * Created by linchao on 2019/12/12.
 */
class NodeViewModel :ViewModel(){
    init {
        viewModelScope.launch {
            NodeService.create().nodeGet()

        }
    }
}