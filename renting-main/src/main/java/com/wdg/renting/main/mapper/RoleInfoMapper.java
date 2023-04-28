package com.wdg.renting.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdg.renting.main.entity.RoleInfo;
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
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    /**
     * 根据用户ID查询角色列表
     */
    List<RoleInfo> selectRolesByUserId(Long userId);

}
