package com.itas.itasbackend.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.util.PasswordUtils;
import com.itas.itasbackend.system.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    IPage<SysUser> selectPageList(Page<SysUser> page, SysUser query);

    @Override
    default boolean save(SysUser entity) {
        String password = entity.getPassword();
        String encode = PasswordUtils.encode(password);
        entity.setPassword(encode);
        return IService.super.save(entity);
    }
}
