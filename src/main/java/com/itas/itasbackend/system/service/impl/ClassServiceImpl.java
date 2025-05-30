package com.itas.itasbackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.Class;
import com.itas.itasbackend.system.mapper.ClassMapper;
import com.itas.itasbackend.system.service.ClassService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Override
    public IPage<Class> selectPageList(Page<Class> page, Class query) {
        QueryWrapper<Class> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
} 