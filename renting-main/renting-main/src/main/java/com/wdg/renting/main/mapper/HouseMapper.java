package com.wdg.renting.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdg.renting.main.entity.House;
import com.wdg.renting.main.req.HousePageReq;
import com.wdg.renting.main.res.HouseResponse;
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
public interface HouseMapper extends BaseMapper<House> {
    List<HouseResponse> listHousePage(HousePageReq param);

    /**
     * 根据出租房主键查询明细
     * @param id 出租房ID
     * @return 出租房明细
     */
    HouseResponse getHouseDetail(@Param("id") Long id);
}
