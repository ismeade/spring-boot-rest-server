package com.ade.demo.server.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TSort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_origin")
    private String dateOrigin;
    @Column(name = "date_sorted")
    private String dateSorted;
    @Column(name = "create_time")
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public TSort setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDateOrigin() {
        return dateOrigin;
    }

    public TSort setDateOrigin(String dateOrigin) {
        this.dateOrigin = dateOrigin;
        return this;
    }

    public String getDateSorted() {
        return dateSorted;
    }

    public TSort setDateSorted(String dateSorted) {
        this.dateSorted = dateSorted;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TSort setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "TSort{" +
                "id=" + id +
                ", dateOrigin='" + dateOrigin + '\'' +
                ", dateSorted='" + dateSorted + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
