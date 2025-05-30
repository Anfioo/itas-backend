package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.Grade;

public interface GradeService extends IService<Grade> {
    IPage<Grade> selectPageList(Page<Grade> page, Grade query);
} 