package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;

@TableName("classes")
public class Class extends BaseEntity {

    @TableId
    private Long classId;


    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String className;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
} 