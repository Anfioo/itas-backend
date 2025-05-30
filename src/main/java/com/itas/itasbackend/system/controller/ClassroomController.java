package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Classroom;
import com.itas.itasbackend.system.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教室管理控制器
 */
@RestController
@RequestMapping("/admin/classroom")
public class ClassroomController extends BaseController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Classroom> getClassroom(@PathVariable("id") Long id) {
        Classroom classroom = classroomService.getById(id);
        return classroom != null ? success(classroom) : error("教室不存在");
    }

    @GetMapping("/page")
    public ApiResponse<PageResult<Classroom>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Classroom query
    ) {
        Page<Classroom> page = new Page<>(pageNum, pageSize);
        IPage<Classroom> result = classroomService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Classroom classroom) {
        boolean result = classroomService.save(classroom);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Classroom classroom) {
        boolean result = classroomService.updateById(classroom);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = classroomService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = classroomService.removeBatchByIds(ids);
        return toResult(result);
    }
} 