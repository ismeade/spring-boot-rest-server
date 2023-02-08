package com.ade.demo.server.modules.serv.service.dto;

import java.time.LocalDateTime;

public class SortDto {

    private Long id;
    private String dateOrigin;
    private String dateSorted;
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public SortDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDateOrigin() {
        return dateOrigin;
    }

    public SortDto setDateOrigin(String dateOrigin) {
        this.dateOrigin = dateOrigin;
        return this;
    }

    public String getDateSorted() {
        return dateSorted;
    }

    public SortDto setDateSorted(String dateSorted) {
        this.dateSorted = dateSorted;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SortDto setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
