package com.comslin.rootcomment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.comslin.rootcomment.adapter.NodeAdapter
import com.comslin.rootcomment.app.BaseVMActivity
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.databinding.ActivityMainBinding
import com.comslin.rootcomment.http.NodeService
import com.comslin.rootcomment.viewmodels.NodeListViewModel

class MainActivity : BaseVMActivity() {

    private var nodeListViewModel: NodeListViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = NodeAdapter()
        binding.rvNode.adapter = adapter
        nodeListViewModel = createViewModel<NodeListViewModel>()
        nodeListViewModel?.nodesLiveData?.observe(this, Observer {
            adapter.submitList(it?.objects)
            binding.user = User("", it.toString())

        })
        nodeListViewModel?.getNodeList()

    }


//    fun <T> request(
//        request: suspend CoroutineScope.() -> BasePageBean,
//        success: ((info: BasePageBean.MetaBean) -> Unit)
//    ) {
//        runOnIo(request, success, {})
//    }
}
