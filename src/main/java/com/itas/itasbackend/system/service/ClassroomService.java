package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.Classroom;

public interface ClassroomService extends IService<Classroom> {
    IPage<Classroom> selectPageList(Page<Classroom> page, Classroom query);
} 