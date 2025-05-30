package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.SubmissionRecord;
import com.itas.itasbackend.system.service.SubmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作业提交记录管理控制器
 */
@RestController
@RequestMapping("/admin/submission-record")
public class SubmissionRecordController extends BaseController {

    private final SubmissionRecordService submissionRecordService;

    public SubmissionRecordController(SubmissionRecordService submissionRecordService) {
        this.submissionRecordService = submissionRecordService;
    }

    @GetMapping("/{id}")
    public ApiResponse<SubmissionRecord> getSubmissionRecord(@PathVariable("id") Long id) {
        SubmissionRecord record = submissionRecordService.getById(id);
        return record != null ? success(record) : error("提交记录不存在");
    }


    @GetMapping("/page")
    public ApiResponse<PageResult<SubmissionRecord>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute SubmissionRecord query
    ) {
        Page<SubmissionRecord> page = new Page<>(pageNum, pageSize);
        IPage<SubmissionRecord> result = submissionRecordService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody SubmissionRecord record) {
        boolean result = submissionRecordService.save(record);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody SubmissionRecord record) {
        boolean result = submissionRecordService.updateById(record);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = submissionRecordService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = submissionRecordService.removeBatchByIds(ids);
        return toResult(result);
    }
} 