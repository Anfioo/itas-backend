package com.itas.itasbackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.Grade;
import com.itas.itasbackend.system.mapper.GradeMapper;
import com.itas.itasbackend.system.service.GradeService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    @Override
    public IPage<Grade> selectPageList(Page<Grade> page, Grade query) {
        QueryWrapper<Grade> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
} 