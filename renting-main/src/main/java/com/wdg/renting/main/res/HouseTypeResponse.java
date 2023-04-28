package com.wdg.renting.main.res;

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
public class HouseTypeResponse {
    private Long id;

    /**
     * 户型名称
     */
    private String name;
}