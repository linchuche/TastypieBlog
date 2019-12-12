package com.comslin.rootcomment.bean;

import java.util.List;

/**
 * Created by linchao on 2019/12/10.
 */
public class BaseBean {

    /**
     * meta : {"limit":20,"next":"/coretree/api/node/?limit=20&offset=20","offset":0,"previous":null,"total_count":51}
     * objects : [{"detail_text":"detaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetaildetail","id":1,"modify_date":"2019-12-08T01:57:10","pub_date":"2019-12-08T01:57:07","resource_uri":"/coretree/api/node/1/","title_text":"title1"},{"detail_text":"detail","id":4,"modify_date":"2019-12-08T14:23:30.887552","pub_date":"2019-12-08T14:23:30.887540","resource_uri":"/coretree/api/node/4/","title_text":"text title0"},{"detail_text":"detail","id":5,"modify_date":"2019-12-08T14:23:30.889910","pub_date":"2019-12-08T14:23:30.889903","resource_uri":"/coretree/api/node/5/","title_text":"text title1"},{"detail_text":"detail","id":6,"modify_date":"2019-12-08T14:23:30.909064","pub_date":"2019-12-08T14:23:30.909053","resource_uri":"/coretree/api/node/6/","title_text":"text title2"},{"detail_text":"detail","id":7,"modify_date":"2019-12-08T14:23:30.910326","pub_date":"2019-12-08T14:23:30.910295","resource_uri":"/coretree/api/node/7/","title_text":"text title3"},{"detail_text":"detail","id":8,"modify_date":"2019-12-08T14:23:30.911407","pub_date":"2019-12-08T14:23:30.911403","resource_uri":"/coretree/api/node/8/","title_text":"text title4"},{"detail_text":"detail","id":9,"modify_date":"2019-12-08T14:23:30.912487","pub_date":"2019-12-08T14:23:30.912482","resource_uri":"/coretree/api/node/9/","title_text":"text title5"},{"detail_text":"detail","id":10,"modify_date":"2019-12-08T14:23:30.913741","pub_date":"2019-12-08T14:23:30.913737","resource_uri":"/coretree/api/node/10/","title_text":"text title6"},{"detail_text":"detail","id":11,"modify_date":"2019-12-08T14:23:30.914854","pub_date":"2019-12-08T14:23:30.914850","resource_uri":"/coretree/api/node/11/","title_text":"text title7"},{"detail_text":"detail","id":12,"modify_date":"2019-12-08T14:23:30.915942","pub_date":"2019-12-08T14:23:30.915937","resource_uri":"/coretree/api/node/12/","title_text":"text title8"},{"detail_text":"detail","id":13,"modify_date":"2019-12-08T14:23:30.917975","pub_date":"2019-12-08T14:23:30.917970","resource_uri":"/coretree/api/node/13/","title_text":"text title9"},{"detail_text":"detail","id":14,"modify_date":"2019-12-08T14:23:30.919491","pub_date":"2019-12-08T14:23:30.919486","resource_uri":"/coretree/api/node/14/","title_text":"text title10"},{"detail_text":"detail","id":15,"modify_date":"2019-12-08T14:23:30.920545","pub_date":"2019-12-08T14:23:30.920540","resource_uri":"/coretree/api/node/15/","title_text":"text title11"},{"detail_text":"detail","id":16,"modify_date":"2019-12-08T14:23:30.921664","pub_date":"2019-12-08T14:23:30.921658","resource_uri":"/coretree/api/node/16/","title_text":"text title12"},{"detail_text":"detail","id":17,"modify_date":"2019-12-08T14:23:30.922968","pub_date":"2019-12-08T14:23:30.922964","resource_uri":"/coretree/api/node/17/","title_text":"text title13"},{"detail_text":"detail","id":18,"modify_date":"2019-12-08T14:23:30.924206","pub_date":"2019-12-08T14:23:30.924201","resource_uri":"/coretree/api/node/18/","title_text":"text title14"},{"detail_text":"detail","id":19,"modify_date":"2019-12-08T14:23:30.926007","pub_date":"2019-12-08T14:23:30.926001","resource_uri":"/coretree/api/node/19/","title_text":"text title15"},{"detail_text":"detail","id":20,"modify_date":"2019-12-08T14:23:30.927134","pub_date":"2019-12-08T14:23:30.927129","resource_uri":"/coretree/api/node/20/","title_text":"text title16"},{"detail_text":"detail","id":21,"modify_date":"2019-12-08T14:23:30.928911","pub_date":"2019-12-08T14:23:30.928906","resource_uri":"/coretree/api/node/21/","title_text":"text title17"},{"detail_text":"detail","id":22,"modify_date":"2019-12-08T14:23:30.929926","pub_date":"2019-12-08T14:23:30.929921","resource_uri":"/coretree/api/node/22/","title_text":"text title18"}]
     */

    private MetaBean meta;
    private List<NodeBean> objects;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<NodeBean> getObjects() {
        return objects;
    }

    public void setObjects(List<NodeBean> objects) {
        this.objects = objects;
    }

    public static class MetaBean {
        /**
         * limit : 20
         * next : /coretree/api/node/?limit=20&offset=20
         * offset : 0
         * previous : null
         * total_count : 51
         */

        private int limit;
        private String next;
        private int offset;
        private Object previous;
        private int total_count;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public Object getPrevious() {
            return previous;
        }

        public void setPrevious(Object previous) {
            this.previous = previous;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        @Override
        public String toString() {
            return "MetaBean{" +
                    "limit=" + limit +
                    ", next='" + next + '\'' +
                    ", offset=" + offset +
                    ", previous=" + previous +
                    ", total_count=" + total_count +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "meta=" + meta +
                ", objects=" + objects +
                '}';
    }
}
