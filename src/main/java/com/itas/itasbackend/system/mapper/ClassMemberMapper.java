package com.itas.itasbackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itas.itasbackend.system.entity.ClassMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMemberMapper extends BaseMapper<ClassMember> {
    // 使用 BaseMapper 的通用方法
} 