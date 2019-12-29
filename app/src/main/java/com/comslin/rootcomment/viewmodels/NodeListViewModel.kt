package com.comslin.rootcomment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.example.paging.pagingwithnetwork.reddit.repository.inMemory.byPage.InMemoryByPageKeyRepository
import com.android.example.paging.pagingwithnetwork.reddit.repository.inMemory.byPage.SubRedditDataSourceFactory
import com.comslin.rootcomment.bean.BasePageBean
import com.comslin.rootcomment.bean.NodeBean
import com.comslin.rootcomment.http.NodeApi
import com.comslin.rootcomment.repository.NetworkState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

/**
 * Created by linchao on 2019/12/12.
 */
class NodeListViewModel internal constructor() : BaseViewModel() {
    val rep = InMemoryByPageKeyRepository(
        redditApi = NodeApi.create(),
        networkExecutor = Executors.newFixedThreadPool(5)
    )
    //    private val
    public val nodeListResult = (rep.postsOfSubreddit())

    public var nodes =
        Transformations.distinctUntilChanged(nodeListResult.pagedList)
    public val networkState = Transformations.distinctUntilChanged(nodeListResult.networkState)

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }

}