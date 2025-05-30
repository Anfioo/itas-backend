package com.itas.itasbackend.system.controller;


import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.SysUser;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.system.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理控制器
 * 提供增删改查接口，继承 BaseController 实现统一返回格式
 */
@RestController
@RequestMapping("/admin/sys-user")
public class SysUserController extends BaseController {

    private final SysUserService userService;

    // 构造函数注入（推荐方式）
    public SysUserController(SysUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ApiResponse<SysUser> getUser(@PathVariable("userId") Long userId) {
        SysUser user = userService.getById(userId);
        return user != null ? success(user) : error("用户不存在");
    }

    @GetMapping("/list")
    public ApiResponse<List<SysUser>> list(@ModelAttribute SysUser query) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(query.getUserName() != null, SysUser::getUserName, query.getUserName());
        List<SysUser> list = userService.list(wrapper);
        return success(list);
    }

    @GetMapping("/page")
    public ApiResponse<PageResult<SysUser>> page(
            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @ModelAttribute SysUser query
    ) {
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        IPage<SysUser> result = userService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody SysUser user) {
        boolean result = userService.save(user);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody SysUser user) {
        boolean result = userService.updateById(user);
        return toResult(result);
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Void> remove(@PathVariable("userId") Long userId) {
//        boolean result = userService.removeById(userId);
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setDelFlag("1");
        boolean result = userService.updateById(sysUser);
        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<String> removeBatch(@RequestBody Long[] userIds) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Long userId : userIds) {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(userId);
            sysUser.setDelFlag("1");
            boolean result = userService.updateById(sysUser);
            stringBuilder.append("删除").append(userId).append(":").append(result ? "成功" : "失败");
        }

//
//        boolean result = userService.removeBatchByIds(List.of(userIds));

        return success(stringBuilder.toString());
    }
}
