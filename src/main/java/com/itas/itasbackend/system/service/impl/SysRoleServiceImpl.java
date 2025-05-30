package com.itas.itasbackend.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.SysRole;
import com.itas.itasbackend.system.mapper.SysRoleMapper;
import com.itas.itasbackend.system.service.SysRoleService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public IPage<SysRole> selectPageList(Page<SysRole> page, SysRole query) {
        QueryWrapper<SysRole> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
}
