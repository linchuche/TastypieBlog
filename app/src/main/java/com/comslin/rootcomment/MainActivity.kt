package com.comslin.rootcomment

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.comslin.rootcomment.adapter.NodeAdapter
import com.comslin.rootcomment.app.BaseVMActivity
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.viewmodels.NodeListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity() {

    private lateinit var nodeListViewModel: NodeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nodeListViewModel = createViewModel<NodeListViewModel>()
        val adapter = NodeAdapter() {
            nodeListViewModel.rep.postsOfSubreddit()
        }
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvNode.addItemDecoration(decoration)
        rvNode.adapter = adapter
        flt.setOnClickListener({
            Toast.makeText(this, "xxx", Toast.LENGTH_LONG).show()
        })
        nodeListViewModel.nodes.observe(this, Observer {
            adapter.submitList(it)
        })
        nodeListViewModel.networkState.observe(this, Observer {
            adapter.setNetworkState(it)
        })


    }
}
