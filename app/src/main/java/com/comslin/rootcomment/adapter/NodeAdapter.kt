package com.comslin.rootcomment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comslin.rootcomment.R
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.databinding.ListItemNodeBinding
import com.comslin.rootcomment.repository.NetworkState

/**
 * Created by linchao on 2019/12/14.
 */
class NodeAdapter(val retryCallback: () -> Unit) :
    PagedListAdapter<NodeBean, RecyclerView.ViewHolder>(NODE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.list_item_node -> NodeViewHolder(
                ListItemNodeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_network_state -> NetworkStateItemViewHolder.create(parent, retryCallback)
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    private var networkState: NetworkState? = null


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.list_item_node -> (holder as NodeViewHolder).bind(getItem(position))
            R.layout.item_network_state -> (holder as NetworkStateItemViewHolder).bindTo(
                networkState
            )
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED
    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.item_network_state
        } else {
            R.layout.list_item_node
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    class NodeViewHolder(private val binding: ListItemNodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListerner {
                binding.node?.let { nodeBean ->
                    navigateToNode(nodeBean, it)
                }
            }
        }

        private fun navigateToNode(
            node: NodeBean,
            it: View
        ) {

        }

        fun bind(item: NodeBean?) {
            binding.apply {
                if (item == null) {
                    node = NodeBean("?", "?", "-1")
                } else {
                    node = item
                }
                executePendingBindings()
            }
        }
    }

    companion object {

        private val NODE_COMPARATOR = object : DiffUtil.ItemCallback<NodeBean>() {
            override fun areItemsTheSame(oldItem: NodeBean, newItem: NodeBean): Boolean =
                oldItem.node_id == newItem.node_id

            override fun areContentsTheSame(oldItem: NodeBean, newItem: NodeBean): Boolean =
                oldItem == newItem
        }

    }


}

private class NodeDiffCallback : DiffUtil.ItemCallback<NodeBean>() {

    override fun areItemsTheSame(oldItem: NodeBean, newItem: NodeBean): Boolean {
        return oldItem.node_id == newItem.node_id
    }

    override fun areContentsTheSame(oldItem: NodeBean, newItem: NodeBean): Boolean {
        return oldItem == newItem
    }
}