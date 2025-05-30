package com.itas.itasbackend.system.controller;


import com.itas.itasbackend.system.service.SysUserRoleService;
import com.itas.itasbackend.util.BaseClass.BaseController;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user-role")
public class SysUserRoleController extends BaseController {

    private final SysUserRoleService userRoleService;

    public SysUserRoleController(SysUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }


//
//    @GetMapping("/list")
//    public ApiResponse<List<ISSysUserRole>> listAll() {
//        return success(userRoleService.list());
//    }
//
//    @PostMapping
//    public ApiResponse<Void> add(@RequestBody ISSysUserRole userRole) {
//        boolean result = userRoleService.save(userRole);
//        return toResult(result);
//    }
//
//    @DeleteMapping
//    public ApiResponse<Void> remove(@RequestBody ISSysUserRole userRole) {
//        boolean result = userRoleService.removeById(userRole);
//        return toResult(result);
//    }
//
//    @PostMapping("/batch")
//    public ApiResponse<Void> addBatch(@RequestBody List<ISSysUserRole> userRoles) {
//        boolean result = userRoleService.saveBatch(userRoles);
//        return toResult(result);
//    }
//
//    @DeleteMapping("/batch")
//    public ApiResponse<Void> removeBatch(@RequestBody List<ISSysUserRole> userRoles) {
//        boolean result = userRoleService.removeBatchByIds(userRoles);
//        return toResult(result);
//    }

}
