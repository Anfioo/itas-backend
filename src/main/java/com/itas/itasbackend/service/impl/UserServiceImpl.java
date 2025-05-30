package com.itas.itasbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.entity.User;
import com.itas.itasbackend.mapper.UserMapper;
import com.itas.itasbackend.service.UserService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> selectPageList(Page<User> page, User query) {
        QueryWrapper<User> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }

}
