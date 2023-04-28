package com.wdg.renting.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdg.renting.main.dto.UserDTO;
import com.wdg.renting.main.entity.*;
import com.wdg.renting.main.mapper.*;
import com.wdg.renting.main.req.RegisterReq;
import com.wdg.renting.main.service.UserInfoService;
import com.wdg.renting.main.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service.impl
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:13
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RoleInfoMapper roleMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private PermissionInfoMapper permissionMapper;

    @Autowired
    private RolePermissionInfoMapper rolePermissionInfoMapper;

    /**
     * 用户登陆
     */
    @Override
    public String login(String username, String password) {
        // 根据用户名查询用户信息
        UserInfo user = findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        // 验证密码是否正确
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        // 生成JWT并返回
        return JwtUtils.generateToken(user.getUsername());
    }

    /**
     * 用户注册
     */
    @Override
    public UserInfo register(RegisterReq param) {
        // 根据用户名检查用户是否已存在
        if (findByUsername(param.getUsername()) != null) {
            throw new RuntimeException("用户名已存在");
        }
        // 对密码进行加密
        UserInfo userInfo = new UserInfo().setUsername(param.getUsername()).setPassword(passwordEncoder.encode(param.getPassword()));
        // 向数据库中插入用户信息
        this.save(userInfo);
        RoleUser roleUser = new RoleUser().setUserId(userInfo.getId()).setRoleId(param.getRole());
        roleUserMapper.insert(roleUser);
        return userInfo;
    }

    /**
     * 查询用户的角色列表
     */
    @Override
    public List<RoleInfo> queryRolesByUserId(Long userId) {
        List<RoleInfo> resultList = new ArrayList<>();
        List<RoleUser> roleUsers = roleUserMapper.selectList(new QueryWrapper<RoleUser>().lambda().eq(RoleUser::getUserId, userId));
        for (RoleUser roleUser : roleUsers) {
            resultList.add(roleMapper.selectById(roleUser.getRoleId()));
        }
        return resultList;
    }

    /**
     * 查询用户的菜单权限列表
     */
    @Override
    public List<PermissionInfo> queryPermissionsByUserId(Long userId) {
        return permissionMapper.selectPermissionsByUserId(userId);
    }

    @Override
    public List<PermissionInfo> queryPermissionsByRoleId(Long roleId) {
        List<PermissionInfo> resultList = new ArrayList<>();
        List<RolePermissionInfo> rolePermissionInfos = rolePermissionInfoMapper.selectList(new QueryWrapper<RolePermissionInfo>().lambda().eq(RolePermissionInfo::getRoleId, roleId));
        if(rolePermissionInfos == null || rolePermissionInfos.size() == 0){
            return null;
        }
        for (RolePermissionInfo rolePermissionInfo : rolePermissionInfos) {
            resultList.addAll(permissionMapper.selectList(new QueryWrapper<PermissionInfo>().lambda().eq(PermissionInfo::getId, rolePermissionInfo.getPermissionId())));
        }
        return resultList;
    }

    @Override
    public UserInfo findByUsername(String username) {
        UserDTO result = new UserDTO();
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return getOne(wrapper);
    }
}

