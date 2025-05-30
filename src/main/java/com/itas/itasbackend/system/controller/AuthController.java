package com.itas.itasbackend.system.controller;

import com.itas.itasbackend.system.entity.SysUser;
import com.itas.itasbackend.system.service.SysUserService;
import com.itas.itasbackend.util.BaseClass.ApiResponse;
import com.itas.itasbackend.util.BaseClass.BaseController;
import com.itas.itasbackend.util.PasswordUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private final SysUserService userService;

    public AuthController(SysUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody SysUser user) {
        // 检查用户名是否已存在
        if (userService.lambdaQuery().eq(SysUser::getUserName, user.getUserName()).exists()) {
            return error("用户名已存在");
        }

        // 检查邮箱是否已存在
        if (user.getEmail() != null && userService.lambdaQuery().eq(SysUser::getEmail, user.getEmail()).exists()) {
            return error("邮箱已被注册");
        }

        // 检查手机号是否已存在
        if (user.getPhoneNumber() != null && userService.lambdaQuery().eq(SysUser::getPhoneNumber, user.getPhoneNumber()).exists()) {
            return error("手机号已被注册");
        }

        // 检查密码强度
        if (!PasswordUtils.isStrongEnough(user.getPassword())) {
            return error("密码强度不足，请确保密码至少8位，包含大小写字母、数字和特殊字符");
        }

        // 设置默认值
        user.setStatus("0"); // 正常状态
        user.setDelFlag("0"); // 未删除
        user.setSex("2"); // 默认性别未知

        // 保存用户
        boolean result = userService.save(user);
        return toResult(result);
    }

    @PostMapping("/login")
    public ApiResponse<Map<String, Object>> login(@RequestBody Map<String, String> loginInfo) {
        String username = loginInfo.get("username");
        String password = loginInfo.get("password");

        if (username == null || password == null) {
            return error("用户名和密码不能为空");
        }

        // 查询用户
        SysUser user = userService.lambdaQuery()
                .eq(SysUser::getUserName, username)
                .one();

        if (user == null) {
            return error("用户不存在");
        }

        // 验证密码
        if (!PasswordUtils.matches(password, user.getPassword())) {
            return error("密码错误");
        }

        // 检查账号状态
        if ("1".equals(user.getStatus())) {
            return error("账号已被停用");
        }

        // 构建返回数据
        Map<String, Object> data = new HashMap<>();
        data.put("userId", user.getUserId());
        data.put("userName", user.getUserName());
        data.put("nickName", user.getNickName());
        data.put("email", user.getEmail());
        data.put("phoneNumber", user.getPhoneNumber());
        data.put("avatar", user.getAvatar());
        data.put("sex", user.getSex());

        return success(data);
    }
} 