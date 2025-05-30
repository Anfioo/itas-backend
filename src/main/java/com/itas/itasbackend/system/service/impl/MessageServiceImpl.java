package com.itas.itasbackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.Message;
import com.itas.itasbackend.system.mapper.MessageMapper;
import com.itas.itasbackend.system.service.MessageService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public IPage<Message> selectPageList(Page<Message> page, Message query) {
        QueryWrapper<Message> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
} 