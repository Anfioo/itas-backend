package com.itas.itasbackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.ClassMember;
import com.itas.itasbackend.system.mapper.ClassMemberMapper;
import com.itas.itasbackend.system.service.ClassMemberService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class ClassMemberServiceImpl extends ServiceImpl<ClassMemberMapper, ClassMember> implements ClassMemberService {

    @Override
    public IPage<ClassMember> selectPageList(Page<ClassMember> page, ClassMember query) {
        QueryWrapper<ClassMember> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
} 