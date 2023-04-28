package com.wdg.renting.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.entity
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:36
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@TableName("house_detail_info")
public class HouseDetail {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 租金
     */
    private BigDecimal price;

    /**
     * 发布者ID
     */
    private Long publisherId;

    /**
     * 区域ID
     */
    private Long regionId;

    /**
     * 出租房ID
     */
    private Long houseId;

    /**
     * 地铁站点ID
     */
    private Long subwayStationId;

    /**
     * 地铁线路ID
     */
    private Long subwayLineId;

    /**
     * 水费/吨
     */
    private BigDecimal waterRate;

    /**
     * 电费/度
     */
    private BigDecimal powerRate;

    /**
     * 具体房号
     */
    private String houseNo;

    /**
     * 省
     */
    private Long provinceId;

    /**
     * 市
     */
    private Long cityId;

    /**
     * 区
     */
    private Long districtId;
}