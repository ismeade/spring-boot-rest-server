package com.ade.demo.server.repository.entity;

import javax.persistence.*;

@Entity
public class TLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
