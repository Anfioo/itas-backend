package com.itas.itasbackend.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itas.itasbackend.system.mapper.SysUserRoleMapper;
import com.itas.itasbackend.system.service.SysUserRoleService;
import com.itas.itasbackend.system.entity.SysUserRole;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
