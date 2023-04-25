package com.wdg.renting.main.service;

import com.wdg.renting.main.base.service.BaseService;
import com.wdg.renting.main.dto.TreeNode;
import com.wdg.renting.main.entity.MapCity;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public interface MapCityService extends BaseService<MapCity> {
    List<TreeNode> listMapCity();

    List<TreeNode> listMapSubway();
}
