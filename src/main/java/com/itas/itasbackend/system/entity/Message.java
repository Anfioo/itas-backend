package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;

import java.time.LocalDateTime;

@TableName("messages")
public class Message extends BaseEntity {

    @TableId
    private Long messageId;

    private Long courseId;
    private LocalDateTime messageDate;

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String content;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
} 