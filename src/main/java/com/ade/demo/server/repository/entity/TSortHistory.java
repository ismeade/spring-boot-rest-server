package com.ade.demo.server.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TSortHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_origin")
    private String dateOrigin;
    @Column(name = "date_sorted")
    private String dateSorted;

    private LocalDateTime requestTime;

    private LocalDateTime responseTime;
}
