package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.ClassMember;

public interface ClassMemberService extends IService<ClassMember> {
    IPage<ClassMember> selectPageList(Page<ClassMember> page, ClassMember query);
} 