package com.itas.itasbackend.entity;

import com.itas.itasbackend.util.BaseClass.BaseEntity;


public class Student extends BaseEntity {
    private Integer id;
    private Integer userId;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}