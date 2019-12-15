package com.comslin.rootcomment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.databinding.ListItemNodeBinding

/**
 * Created by linchao on 2019/12/14.
 */
class NodeAdapter : ListAdapter<NodeBean, RecyclerView.ViewHolder>(NodeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NodeViewHolder(
            ListItemNodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val node = getItem(position)
        (holder as NodeViewHolder).bind(node)
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

        fun bind(item: NodeBean) {
            binding.apply {
                node = item
                executePendingBindings()
            }
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