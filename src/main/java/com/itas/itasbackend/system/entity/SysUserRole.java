package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.util.BaseClass.BaseEntity;


import java.time.LocalDateTime;


@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    private Long userId;

    private String roleKey;

    private LocalDateTime grantTime;

    public Long getUserId() {
        return userId;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public LocalDateTime getGrantTime() {
        return grantTime;
    }
}
