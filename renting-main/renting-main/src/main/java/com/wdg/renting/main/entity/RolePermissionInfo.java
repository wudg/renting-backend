package com.wdg.renting.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.entity
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  11:11
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("role_permission_relation")
public class RolePermissionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long roleId;

    /**
     * ID
     */
    private Long permissionId;


}

