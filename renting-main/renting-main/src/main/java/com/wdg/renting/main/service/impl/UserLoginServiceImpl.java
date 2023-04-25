package com.wdg.renting.main.service.impl;

import com.wdg.renting.main.entity.PermissionInfo;
import com.wdg.renting.main.entity.RoleInfo;
import com.wdg.renting.main.entity.UserInfo;
import com.wdg.renting.main.service.UserInfoService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service.impl
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:13
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserLoginServiceImpl implements UserDetailsService {
    @Resource
    private UserInfoService userInfoService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userInfoService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<RoleInfo> roleInfos = userInfoService.queryRolesByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleInfo role : roleInfos) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
            List<PermissionInfo> permissionInfos = userInfoService.queryPermissionsByRoleId(role.getId());
            if(Objects.isNull(permissionInfos) || permissionInfos.size() == 0){
                continue;
            }
            for (PermissionInfo permission : permissionInfos) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode().toUpperCase()));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }
}

