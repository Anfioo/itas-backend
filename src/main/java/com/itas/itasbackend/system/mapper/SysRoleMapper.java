package com.itas.itasbackend.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itas.itasbackend.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    // 使用 BaseMapper 的通用方法
}
