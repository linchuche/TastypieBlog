package com.comslin.rootcomment.bean;

import java.util.List;

/**
 * Created by linchao on 2019/12/10.
 */
public class BasePageBean {
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
        return "BasePageBean{" +
                "meta=" + meta +
                ", objects=" + objects +
                '}';
    }
}
