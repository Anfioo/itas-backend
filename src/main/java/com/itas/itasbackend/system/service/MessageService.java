package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.Message;

public interface MessageService extends IService<Message> {
    IPage<Message> selectPageList(Page<Message> page, Message query);
} 