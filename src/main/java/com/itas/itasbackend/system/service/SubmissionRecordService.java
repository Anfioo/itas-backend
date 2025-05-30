package com.itas.itasbackend.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itas.itasbackend.system.entity.SubmissionRecord;

public interface SubmissionRecordService extends IService<SubmissionRecord> {
    IPage<SubmissionRecord> selectPageList(Page<SubmissionRecord> page, SubmissionRecord query);
} 