package com.wdg.renting.main.req;

import lombok.Data;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.req
 * @Author: 吴第广
 * @CreateTime: 2023-04-25  20:04
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class BasePageReq {

    /**
     * 页数
     */
    private Integer pageNum = 1;

    /**
     * 数量
     */
    private Integer pageSize = 6;
}
