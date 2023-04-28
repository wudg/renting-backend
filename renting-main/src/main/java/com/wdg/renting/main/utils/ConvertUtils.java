package com.wdg.renting.main.utils;

import com.wdg.renting.main.dto.TreeNode;
import com.wdg.renting.main.entity.NcRegion;
import com.wdg.renting.main.entity.NcSubway;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.utils
 * @Author: 吴第广
 * @CreateTime: 2023-04-24  09:36
 * @Description: TODO
 * @Version: 1.0
 */
public class ConvertUtils {

    public static TreeNode convertMapCityToDTO(NcRegion x) {
        return new TreeNode().setPid(x.getPid()).setLabel(x.getName()).setValue(x.getId());
    }

    public static TreeNode convertMapSubwayToDTO(NcSubway x) {
        return new TreeNode().setPid(x.getPid()).setLabel(x.getName()).setValue(x.getId());
    }
}
