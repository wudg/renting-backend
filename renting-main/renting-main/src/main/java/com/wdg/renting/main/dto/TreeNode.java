package com.wdg.renting.main.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.dto
 * @Author: 吴第广
 * @CreateTime: 2023-04-24  17:02
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TreeNode {
    /**
     * 地区唯一值
     */
    private Long value;

    /**
     * 父级
     */
    private Long pid;

    /**
     * 地区名称
     */
    private String label;

    /**
     * 子地区
     */
    private List<TreeNode> children;
}
