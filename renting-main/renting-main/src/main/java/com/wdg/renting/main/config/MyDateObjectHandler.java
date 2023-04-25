package com.wdg.renting.main.config;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.config
 * @Author: 吴第广
 * @CreateTime: 2023-04-23  18:18
 * @Description: TODO
 * @Version: 1.0
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MyDateObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        log.info("come to insert fill .........");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime",new Date().getTime()/1000,metaObject);
        this.setFieldValByName("updateTime",new Date().getTime()/1000,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        log.info("come to update fill .......");

        this.setFieldValByName("updateTime",new Date().getTime()/1000,metaObject);

    }
}