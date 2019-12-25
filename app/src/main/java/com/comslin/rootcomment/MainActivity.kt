package com.comslin.rootcomment

import android.os.Bundle
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
        setupScrollListener()

        val adapter = NodeAdapter() {
            //            nodeListViewModel.loadMoreNodeList()
        }
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvNode.addItemDecoration(decoration)
        rvNode.adapter = adapter


        nodeListViewModel.nodeListResult.observe(this, Observer {
            adapter.submitList(it.objects) {
                // Workaround for an issue where RecyclerView incorrectly uses the loading / spinner
                // item added to the end of the list as an anchor during initial load.
                val layoutManager = (rvNode.layoutManager as LinearLayoutManager)
                val position = layoutManager.findFirstCompletelyVisibleItemPosition()
                if (position != RecyclerView.NO_POSITION) {
                    rvNode.scrollToPosition(position)
                }
            }
            val myList: ArrayList<NodeBean> = ArrayList()
            myList.add(NodeBean("xx", "xx", "xxx"))
            adapter.submitList(myList)
        })
        nodeListViewModel.networkState.observe(this, Observer {
            adapter.setNetworkState(it)
        })
//        nodeListViewModel.loadMoreNodeList()


    }

    private fun setupScrollListener() {
        val layoutManager =
            rvNode.layoutManager as androidx.recyclerview.widget.LinearLayoutManager
        rvNode.addOnScrollListener(object :
            androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
            override fun onScrolled(
                recyclerView: androidx.recyclerview.widget.RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                nodeListViewModel.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)
            }
        })
    }


}
