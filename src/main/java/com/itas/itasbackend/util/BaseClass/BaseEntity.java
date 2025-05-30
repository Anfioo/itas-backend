package com.itas.itasbackend.util.BaseClass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itas.itasbackend.query.QueryAutoCondition;
import com.itas.itasbackend.query.QueryCondition;
import com.itas.itasbackend.query.QueryStrategy;


import java.io.Serializable;
import java.time.LocalDateTime;

@QueryAutoCondition

public class BaseEntity implements Serializable {
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime createdAt;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime updatedAt;


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
