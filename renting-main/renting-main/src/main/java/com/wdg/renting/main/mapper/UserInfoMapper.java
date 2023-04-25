package com.wdg.renting.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdg.renting.main.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.mapper
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:11
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo findByUsername(String username);

}

