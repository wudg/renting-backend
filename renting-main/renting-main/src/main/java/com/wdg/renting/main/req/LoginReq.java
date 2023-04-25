package com.wdg.renting.main.req;

import lombok.Data;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.req
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:01
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class LoginReq {
    private String username;

    private String password;
}
