package com.comslin.rootcomment.bean

/**
 * Created by linchao on 2019/12/10.
 */
data class NodeBean(
    val title_text: String,
    val detail_text: String,
    val node_id: String,
    val pub_date: String = "",
    val resource_uri: String = ""
)