package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;

@TableName("resources")
public class Resource extends BaseEntity {

    @TableId
    private Long resourceId;

    private Long courseId;
    private Long parentId;

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String resourceType;

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String title;

    private String content;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
} 