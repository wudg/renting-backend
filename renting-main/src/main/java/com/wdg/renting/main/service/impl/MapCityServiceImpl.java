package com.wdg.renting.main.service.impl;

import com.wdg.renting.main.base.service.impl.BaseServiceImpl;
import com.wdg.renting.main.dto.TreeNode;
import com.wdg.renting.main.entity.MapCity;
import com.wdg.renting.main.entity.NcRegion;
import com.wdg.renting.main.entity.NcSubway;
import com.wdg.renting.main.mapper.MapCityMapper;
import com.wdg.renting.main.service.MapCityService;
import com.wdg.renting.main.service.NcRegionService;
import com.wdg.renting.main.service.NcSubwayService;
import com.wdg.renting.main.utils.CommonUtils;
import com.wdg.renting.main.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service.impl
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:47
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class MapCityServiceImpl extends BaseServiceImpl<MapCityMapper, MapCity> implements MapCityService {
    @Autowired
    private NcRegionService ncRegionService;

    @Autowired
    private NcSubwayService ncSubwayService;
    @Override
    public List<TreeNode> listMapCity() {
        List<NcRegion> region = ncRegionService.list();
        List<TreeNode> list = region.stream().map(ConvertUtils::convertMapCityToDTO).collect(Collectors.toList());
        return CommonUtils.buildTreeUseList(list, 1L);
    }

    @Override
    public List<TreeNode> listMapSubway() {
        List<NcSubway> region = ncSubwayService.list();
        List<TreeNode> list = region.stream().map(ConvertUtils::convertMapSubwayToDTO).collect(Collectors.toList());
        return CommonUtils.buildTreeUseList(list, 1L);
    }
}
