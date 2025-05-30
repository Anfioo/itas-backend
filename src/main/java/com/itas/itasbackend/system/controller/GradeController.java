package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Grade;
import com.itas.itasbackend.system.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成绩管理控制器
 */
@RestController
@RequestMapping("/admin/grade")
public class GradeController extends BaseController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Grade> getGrade(@PathVariable("id") Long id) {
        Grade grade = gradeService.getById(id);
        return grade != null ? success(grade) : error("成绩记录不存在");
    }



    @GetMapping("/page")
    public ApiResponse<PageResult<Grade>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Grade query
    ) {
        Page<Grade> page = new Page<>(pageNum, pageSize);
        IPage<Grade> result = gradeService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Grade grade) {
        boolean result = gradeService.save(grade);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Grade grade) {
        boolean result = gradeService.updateById(grade);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = gradeService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = gradeService.removeBatchByIds(ids);
        return toResult(result);
    }
} 