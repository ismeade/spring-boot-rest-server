package com.ade.demo.server.modules.tools.rest.vo;

import java.util.List;

public class SortRequest {

    /**
     * 排序类型：默认升序
     */
    private String sortType = "ASE";
    private List<Object> data;

    public String getSortType() {
        return sortType;
    }

    public SortRequest setSortType(String sortType) {
        this.sortType = sortType;
        return this;
    }

    public List<Object> getData() {
        return data;
    }

    public SortRequest setData(List<Object> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "SortRequest{" +
                "sortType='" + sortType + '\'' +
                ", data=" + data +
                '}';
    }
}
