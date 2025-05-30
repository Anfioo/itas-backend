package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.Assignment;

public interface AssignmentService extends IService<Assignment> {
    IPage<Assignment> selectPageList(Page<Assignment> page, Assignment query);
} 