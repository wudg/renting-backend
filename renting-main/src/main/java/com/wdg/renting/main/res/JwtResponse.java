package com.wdg.renting.main.res;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.res
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:55
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

}
