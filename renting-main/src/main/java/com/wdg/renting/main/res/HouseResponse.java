package com.wdg.renting.main.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 关联楼栋
     */
    private String houseType;

    /**
     * 位置
     */
    private String address;

    /**
     * 区
     */
    private String district;

    /**
     * 小区名
     */
    private String villageName;

    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 朝向
     */
    private String toward;

    /**
     * 图片
     */
    private String images;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否有卫生间
     */
    private Boolean toilet;

    /**
     * 出租方式
     */
    private Boolean rentalMethod;

    /**
     * 厨房
     */
    private Boolean kitchen;

    /**
     * 阳台
     */
    private Boolean balcony;

    /**
     * 主图
     */
    private String cover;

    /**
     * 附近公交
     */
    private String bus;

    /**
     * 附近地铁站点
     */
    private String subwayStation;

    /**
     * 水费/吨
     */
    private BigDecimal waterRate;

    /**
     * 电费/度
     */
    private BigDecimal powerRate;

    /**
     * 附近地铁线路
     */
    private String subwayLine;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}