package com.itas.itasbackend.teacher.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Assignment;
import com.itas.itasbackend.system.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作业管理控制器
 */
@RestController
@RequestMapping("/admin/assignment")
public class AssignmentController extends BaseController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Assignment> getAssignment(@PathVariable("id") Long id) {
        Assignment assignment = assignmentService.getById(id);
        return assignment != null ? success(assignment) : error("作业不存在");
    }


    @GetMapping("/page")
    public ApiResponse<PageResult<Assignment>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Assignment query
    ) {
        Page<Assignment> page = new Page<>(pageNum, pageSize);
        IPage<Assignment> result = assignmentService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Assignment assignment) {
        boolean result = assignmentService.save(assignment);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Assignment assignment) {
        boolean result = assignmentService.updateById(assignment);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = assignmentService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = assignmentService.removeBatchByIds(ids);
        return toResult(result);
    }
} 