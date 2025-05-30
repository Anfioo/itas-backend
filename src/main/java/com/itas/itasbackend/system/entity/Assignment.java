package com.itas.itasbackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itas.itasbackend.core.QueryCondition;
import com.itas.itasbackend.core.QueryStrategy;
import com.itas.itasbackend.util.BaseClass.BaseEntity;

import java.time.LocalDateTime;

@TableName("assignments")
public class Assignment extends BaseEntity {

    @TableId
    private Long assignmentId;

    private Long courseId;

    @QueryCondition(strategy = QueryStrategy.LIKE)
    private String title;

    private String description;
    private LocalDateTime dueDate;
    private Integer maxScore;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }
} 