package com.wdg.renting.main.req;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.entity
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:36
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class HouseAddReq {
    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 水费/吨
     */
    private BigDecimal waterRate;

    /**
     * 出租方式0-整租 1-合租
     */
    private Boolean rentalMethod;

    /**
     * 电费/度
     */
    private BigDecimal powerRate;

    /**
     * 房号
     */
    private String houseNo;

    /**
     * 图片
     */
    private List<String> photos;

    /**
     * 主图
     */
    private String cover;

    /**
     * 区域ID
     */
    private List<Long> location;

    /**
     * 地铁ID
     */
    private List<Long> subwayLocation;

    /**
     * 户型ID
     */
    private Long houseTypeId;

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
     * 描述
     */
    private String description;


    /**
     * 卫生间数量
     */
    private Boolean toilet;

    /**
     * 厨房
     */
    private Boolean kitchen;

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