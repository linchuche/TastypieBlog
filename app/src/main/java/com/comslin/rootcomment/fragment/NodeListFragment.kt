package com.comslin.rootcomment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.comslin.rootcomment.adapter.NodeAdapter
import com.comslin.rootcomment.databinding.FragmentNodeListBinding
import com.comslin.rootcomment.viewmodels.NodeListViewModel

/**
 * Created by linchao on 2019/12/14.
 */
class NodeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNodeListBinding.inflate(inflater, container, false);
        context ?: return binding.root



        return binding.root
    }
}