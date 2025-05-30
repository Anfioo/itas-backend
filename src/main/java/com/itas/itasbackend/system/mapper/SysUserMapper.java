package com.itas.itasbackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itas.itasbackend.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    // 不需要再写任何方法，全部使用 BaseMapper 的默认方法
}
