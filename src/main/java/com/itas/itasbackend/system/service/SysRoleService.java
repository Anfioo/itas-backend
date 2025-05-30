package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.SysRole;

public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> selectPageList(Page<SysRole> page, SysRole query);
}
