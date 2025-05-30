package com.itas.itasbackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.entity.SubmissionRecord;
import com.itas.itasbackend.system.mapper.SubmissionRecordMapper;
import com.itas.itasbackend.system.service.SubmissionRecordService;
import com.itas.itasbackend.util.QueryWrapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class SubmissionRecordServiceImpl extends ServiceImpl<SubmissionRecordMapper, SubmissionRecord> implements SubmissionRecordService {

    @Override
    public IPage<SubmissionRecord> selectPageList(Page<SubmissionRecord> page, SubmissionRecord query) {
        QueryWrapper<SubmissionRecord> wrapper = QueryWrapperBuilder.buildQueryWrapper(query);
        return this.page(page, wrapper);
    }
} 