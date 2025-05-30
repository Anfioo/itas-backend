package com.itas.itasbackend.util.BaseClass;

import com.itas.itasbackend.core.QueryAutoCondition;
import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;


import java.io.Serializable;
import java.time.LocalDateTime;

@QueryAutoCondition
public class BaseEntity implements Serializable {

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime createTime;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime updateTime;


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
