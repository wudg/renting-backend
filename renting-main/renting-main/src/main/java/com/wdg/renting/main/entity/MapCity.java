package com.wdg.renting.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@TableName("map_city")
public class MapCity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long pid;

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
}