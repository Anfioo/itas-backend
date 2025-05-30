package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.util.BaseClass.BaseEntity;

@TableName("class_members")
public class ClassMember extends BaseEntity {

    private Long classId;
    private Long userId;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
} 