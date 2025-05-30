package com.itas.itasbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itas.itasbackend.config.PageResult;
import com.itas.itasbackend.entity.User;
import com.itas.itasbackend.service.UserService;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理控制器
 * 提供增删改查接口，继承 BaseController 实现统一返回格式
 */
@RestController
@RequestMapping("/sys-user")
public class UserController extends BaseController {

    private final UserService userService;

    // 构造函数注入（推荐方式）
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/test")
    public ApiResponse<Map<String, Object>> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello");
        map.put("code", 200);
        return ApiResponse.ok(map);
    }


    @GetMapping("/{userId}")
    public ApiResponse<User> getUser(@PathVariable("userId") Long userId) {
        User user = userService.getById(userId);
        return user != null ? success(user) : error("用户不存在");
    }

    @GetMapping("/list")
    public ApiResponse<List<User>> list(@ModelAttribute User query) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(query.getUsername() != null, User::getUsername, query.getUsername());
        List<User> list = userService.list(wrapper);

        return success(list);
    }


    @GetMapping("/page")
    public ApiResponse<PageResult<User>> page(
            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @ModelAttribute User query
    ) {
        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> result = userService.selectPageList(page, query);
        return success(new PageResult<>(result));
    }

    @PostMapping
    public ApiResponse<Void> add(@RequestBody User user) {
        boolean result = userService.save(user);
        return toResult(result);
    }

    @PutMapping
    public ApiResponse<Void> edit(@RequestBody User user) {
        boolean result = userService.updateById(user);
        return toResult(result);
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Void> remove(@PathVariable("userId") Long userId) {
        boolean result = userService.removeById(userId);

        return toResult(result);
    }

    @DeleteMapping("/batch")
    public ApiResponse<Void> removeBatch(@RequestBody Long[] userIds) {
        boolean result = userService.removeBatchByIds(List.of(userIds));

        return toResult(result);
    }
}
