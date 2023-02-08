package com.ade.demo.server.modules.serv.rest.vo;


public class SortVo {

    private Long id;
    /** 原始数据 */
    private String dateOrigin;
    /** 排序后数据 */
    private String dateSorted;
    /** 创建时间 */
    private String createTime;

    public Long getId() {
        return id;
    }

    public SortVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDateOrigin() {
        return dateOrigin;
    }

    public SortVo setDateOrigin(String dateOrigin) {
        this.dateOrigin = dateOrigin;
        return this;
    }

    public String getDateSorted() {
        return dateSorted;
    }

    public SortVo setDateSorted(String dateSorted) {
        this.dateSorted = dateSorted;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public SortVo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}
