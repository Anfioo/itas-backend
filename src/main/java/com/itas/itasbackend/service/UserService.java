package com.itas.itasbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.entity.User;
import com.itas.itasbackend.util.QueryWrapperBuilder;

public interface UserService extends IService<User> {
    // 可拓展根据 userId 查询角色、批量添加角色等方法


    public IPage<User> selectPageList(Page<User> page, User query);
}
