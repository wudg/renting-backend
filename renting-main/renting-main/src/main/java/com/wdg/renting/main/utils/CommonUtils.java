package com.wdg.renting.main.utils;

import com.wdg.renting.main.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.utils
 * @Author: 吴第广
 * @CreateTime: 2023-04-24  17:08
 * @Description: TODO
 * @Version: 1.0
 */

public class CommonUtils {
    public static List<TreeNode> buildTreeUseList(List<TreeNode> treeList, long id){
        //收集传递的集合中父id相同的TreeNode
        List<TreeNode> children = null;
        for (TreeNode treeNode : treeList) {
            //判断该节点的父id，是否与传入的父id相同，相同则递归设置其孩子节点，并将该节点放入children集合中
            if(treeNode.getPid() == id){
                //递归设置其孩子节点
                treeNode.setChildren(buildTreeUseList(treeList, treeNode.getValue()));
                //放入children集合
                if(null == children){
                    children = new ArrayList<>();
                }
                children.add(treeNode);
            }
        }
        return children;
    }
}
