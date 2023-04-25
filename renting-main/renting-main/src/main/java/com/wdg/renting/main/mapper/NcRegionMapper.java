package com.wdg.renting.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdg.renting.main.entity.NcRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.mapper
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:46
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface NcRegionMapper extends BaseMapper<NcRegion> {
    List<NcRegion> getParentByChildId(@Param("nodeId") Long nodeId);
}
