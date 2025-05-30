package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Course;
import com.itas.itasbackend.system.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程管理控制器
 */
@RestController
@RequestMapping("/admin/course")
public class CourseController extends BaseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Course> getCourse(@PathVariable("id") Long id) {
        Course course = courseService.getById(id);
        return course != null ? success(course) : error("课程不存在");
    }


    @GetMapping("/page")
    public ApiResponse<PageResult<Course>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Course query
    ) {
        Page<Course> page = new Page<>(pageNum, pageSize);
        IPage<Course> result = courseService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Course course) {
        boolean result = courseService.save(course);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Course course) {
        boolean result = courseService.updateById(course);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = courseService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = courseService.removeBatchByIds(ids);
        return toResult(result);
    }
} 