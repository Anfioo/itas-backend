package com.itas.itasbackend.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;



import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.system.entity.SysRole;
import com.itas.itasbackend.system.service.SysRoleService;



import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统角色管理控制器
 */
@RestController
@RequestMapping("/admin/sys-role")
public class SysRoleController extends BaseController {

    private final SysRoleService roleService;

    /**
     * 构造方法，注入角色服务
     *
     * @param roleService 角色服务
     */
    public SysRoleController(SysRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 根据角色Key获取角色详情
     *
     * @param roleKey 角色唯一标识
     * @return 包含角色信息的响应结果
     */
    @GetMapping("/{roleKey}")
    public ApiResponse<SysRole> getRole(@PathVariable("roleKey") String roleKey) {
        SysRole role = roleService.getById(roleKey);
        return role != null ? success(role) : error("角色不存在");
    }



    /**
     * 分页查询角色列表
     *
     * @param pageNum  当前页码，默认为1
     * @param pageSize 每页记录数，默认为10
     * @param query    查询条件对象
     * @return 包含分页结果的响应
     */
    @GetMapping("/page")
    public ApiResponse<PageResult<SysRole>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @ModelAttribute SysRole query
    ) {
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        IPage<SysRole> result = roleService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    /**
     * 新增角色
     *
     * @param role 角色信息
     * @return 操作结果
     */
    @PostMapping
    public ApiResponse<Void> add(@RequestBody SysRole role) {
        boolean result = roleService.save(role);
        return toResult(result);
    }

    /**
     * 修改角色信息
     *
     * @param role 角色信息
     * @return 操作结果
     */
    @PutMapping
    public ApiResponse<Void> edit(@RequestBody SysRole role) {
        boolean result = roleService.updateById(role);
        return toResult(result);
    }

    /**
     * 删除单个角色
     *
     * @param roleKey 角色唯一标识
     * @return 操作结果
     */
    @DeleteMapping("/{roleKey}")
    public ApiResponse<Void> remove(@PathVariable("roleKey") String roleKey) {
        boolean result = roleService.removeById(roleKey);
        return toResult(result);
    }

    /**
     * 批量删除角色
     *
     * @param roleKeys 角色唯一标识列表
     * @return 操作结果
     */
    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody List<String> roleKeys) {
        boolean result = roleService.removeBatchByIds(roleKeys);
        return toResult(result);
    }
}