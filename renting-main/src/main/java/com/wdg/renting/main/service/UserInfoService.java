package com.wdg.renting.main.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdg.renting.main.entity.PermissionInfo;
import com.wdg.renting.main.entity.RoleInfo;
import com.wdg.renting.main.entity.UserInfo;
import com.wdg.renting.main.req.RegisterReq;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:12
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 用户登陆
     */
    String login(String username, String password);

    /**
     * 用户注册
     */
    UserInfo register(RegisterReq param);

    /**
     * 查询用户的角色列表
     */
    List<RoleInfo> queryRolesByUserId(Long userId);

    /**
     * 查询用户的菜单权限列表
     */
    List<PermissionInfo> queryPermissionsByUserId(Long userId);

    /**
     * 查询角色的菜单权限列表
     */
    List<PermissionInfo> queryPermissionsByRoleId(Long roleId);

    /**
     * 根据用户名查询用户信息
     */
    UserInfo findByUsername(String username);

}

