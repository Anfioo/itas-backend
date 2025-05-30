package com.itas.itasbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.query.QueryCondition;
import com.itas.itasbackend.query.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;



@TableName("user")
public class User extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String username;
    private String password;
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }


}

