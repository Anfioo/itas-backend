package com.itas.itasbackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itas.itasbackend.system.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    // 使用 BaseMapper 的通用方法
}