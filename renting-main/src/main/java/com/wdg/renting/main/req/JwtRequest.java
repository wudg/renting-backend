package com.wdg.renting.main.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.req
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:54
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;

    private String password;

}
