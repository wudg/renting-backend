package com.wdg.renting.main.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("house_info")
@Accessors(chain = true)
public class House {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 图片
     */
    private String images;

    /**
     * 主图
     */
    private String cover;

    /**
     * 描述
     */
    private String description;

    /**
     * 户型ID
     */
    private Long houseTypeId;

    /**
     * 卫生间数量
     */
    private Boolean toilet;

    /**
     * 厨房
     */
    private Boolean kitchen;

    /**
     * 出租方式
     */
    private String rentalMethod;

    /**
     * 装修程度
     */
    private String level;

    /**
     * 小区/村名字
     */
    private String villageName;

    /**
     * 朝向
     */
    private String toward;

    /**
     * 阳台
     */
    private Boolean balcony;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
}