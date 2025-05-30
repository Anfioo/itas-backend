package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Class;
import com.itas.itasbackend.system.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理控制器
 */
@RestController
@RequestMapping("/admin/class")
public class ClassController extends BaseController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Class> getClass(@PathVariable("id") Long id) {
        Class clazz = classService.getById(id);
        return clazz != null ? success(clazz) : error("班级不存在");
    }



    @GetMapping("/page")
    public ApiResponse<PageResult<Class>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Class query
    ) {
        Page<Class> page = new Page<>(pageNum, pageSize);
        IPage<Class> result = classService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Class clazz) {
        boolean result = classService.save(clazz);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Class clazz) {
        boolean result = classService.updateById(clazz);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = classService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = classService.removeBatchByIds(ids);
        return toResult(result);
    }
} 