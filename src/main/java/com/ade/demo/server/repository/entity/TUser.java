package com.ade.demo.server.repository.entity;

import javax.persistence.*;

@Entity
public class TUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public TUser(){

    }

    public TUser(Long id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public TUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TUser setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TUser setAge(int age) {
        this.age = age;
        return this;
    }
}
