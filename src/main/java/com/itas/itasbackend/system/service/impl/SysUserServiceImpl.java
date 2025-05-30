package com.itas.itasbackend.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.service.SysUserService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import com.itas.itasbackend.system.entity.SysUser;
import com.itas.itasbackend.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPageList(Page<SysUser> page, SysUser query) {
        QueryWrapper<SysUser> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }




}
