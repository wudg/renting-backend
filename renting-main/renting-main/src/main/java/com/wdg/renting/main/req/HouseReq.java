package com.wdg.renting.main.req;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.req
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:01
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class HouseReq {
    private Integer id;
    private String title;
    private String houseType;
    private BigDecimal area;
    private BigDecimal price;
    private String city;
    private String address;
    private String description;
    private Integer ownerId;
    private Date createTime;
    private Date updateTime;
}
