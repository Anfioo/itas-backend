package com.itas.itasbackend.system.entity;


import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.time.LocalDateTime;



@TableName("sys_user")
public class SysUser extends BaseEntity {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;


    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String userName;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String nickName;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String phoneNumber;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime createTime;
    @QueryCondition(strategy = QueryStrategy.LIKE)
    private LocalDateTime updateTime;


    private String password;
    private String email;
    private String avatar;
    private String sex;
    private String status;
    private String delFlag;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}


