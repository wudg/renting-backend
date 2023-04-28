package com.wdg.renting.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.entity
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:36
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("nc_subway")
public class NcSubway {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 地铁名称
     */
    private String name;

    /**
     * 父级ID
     */
    private Long pid;
}