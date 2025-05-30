package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.Resource;
import com.itas.itasbackend.system.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教学资源管理控制器
 */
@RestController
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Resource> getResource(@PathVariable("id") Long id) {
        Resource resource = resourceService.getById(id);
        return resource != null ? success(resource) : error("资源不存在");
    }



    @GetMapping("/page")
    public ApiResponse<PageResult<Resource>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute Resource query
    ) {
        Page<Resource> page = new Page<>(pageNum, pageSize);
        IPage<Resource> result = resourceService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody Resource resource) {
        boolean result = resourceService.save(resource);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody Resource resource) {
        boolean result = resourceService.updateById(resource);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = resourceService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = resourceService.removeBatchByIds(ids);
        return toResult(result);
    }
} 