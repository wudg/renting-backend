package com.wdg.renting.main.entity;

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
public class Order {
    private Integer id;
    private Integer userId;
    private Integer houseId;
    private Integer status;
}
