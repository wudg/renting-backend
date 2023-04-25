package com.wdg.renting.main.controller;

import com.wdg.renting.main.base.common.Result;
import com.wdg.renting.main.entity.PermissionInfo;
import com.wdg.renting.main.entity.RoleInfo;
import com.wdg.renting.main.entity.UserInfo;
import com.wdg.renting.main.req.LoginReq;
import com.wdg.renting.main.req.RegisterReq;
import com.wdg.renting.main.service.RoleInfoService;
import com.wdg.renting.main.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.controller
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:16
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private RoleInfoService roleInfoService;

    /**
     * 用户登陆
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginReq param) {
        String token = userService.login(param.getUsername(), param.getPassword());
        return Result.success("登陆成功", token);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterReq param) {
        UserInfo result = userService.register(param);
        return Result.success("注册成功", result);
    }

    /**
     * 查询用户的角色列表
     */
    @GetMapping("/user/roles")
    public Result queryUserRoles() {
        Long userId = getCurrentUserId();
        List<RoleInfo> roles = userService.queryRolesByUserId(userId);
        return Result.success("查询用户角色成功", roles);
    }
    /**
     * 查询用户的角色列表
     */
    @GetMapping("/roles")
    public Result queryRoles() {
        List<RoleInfo> roles = roleInfoService.list();
        return Result.success("查询用户角色成功", roles);
    }

    /**
     * 查询用户的菜单权限列表
     */
    @GetMapping("/user/permissions")
    public Result queryUserPermissions() {
        Long userId = getCurrentUserId();
        List<PermissionInfo> permissions = userService.queryPermissionsByUserId(userId);
        return Result.success("查询用户权限成功", permissions);
    }

    /**
     * 获取当前请求的用户ID
     */
    private Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return Long.parseLong(userDetails.getUsername());
    }

}

