package com.itas.itasbackend.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.ClassMember;
import com.itas.itasbackend.system.service.ClassMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级成员管理控制器
 */
@RestController
@RequestMapping("/admin/class-member")
public class ClassMemberController extends BaseController {

    private final ClassMemberService classMemberService;

    public ClassMemberController(ClassMemberService classMemberService) {
        this.classMemberService = classMemberService;
    }

    @GetMapping("/{id}")
    public ApiResponse<ClassMember> getClassMember(@PathVariable("id") Long id) {
        ClassMember member = classMemberService.getById(id);
        return member != null ? success(member) : error("班级成员不存在");
    }


    @GetMapping("/page")
    public ApiResponse<PageResult<ClassMember>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute ClassMember query
    ) {
        Page<ClassMember> page = new Page<>(pageNum, pageSize);
        IPage<ClassMember> result = classMemberService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody ClassMember member) {
        boolean result = classMemberService.save(member);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody ClassMember member) {
        boolean result = classMemberService.updateById(member);
        return toResult(result);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> remove(@PathVariable("id") Long id) {
        boolean result = classMemberService.removeById(id);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<Long> ids) {
        boolean result = classMemberService.removeBatchByIds(ids);
        return toResult(result);
    }
} 