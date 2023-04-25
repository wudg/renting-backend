package com.wdg.renting.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdg.renting.main.entity.PermissionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.mapper
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:14
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface PermissionInfoMapper extends BaseMapper<PermissionInfo> {

    /**
     * 根据用户ID查询菜单权限列表
     */
    List<PermissionInfo> selectPermissionsByUserId(Long userId);

}

