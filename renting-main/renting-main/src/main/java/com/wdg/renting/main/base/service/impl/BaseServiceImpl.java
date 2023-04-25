package com.wdg.renting.main.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdg.renting.main.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.base.service.impl
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:55
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    @Autowired
    protected M mapper;
}