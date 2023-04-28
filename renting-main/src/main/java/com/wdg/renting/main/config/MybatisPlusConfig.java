package com.wdg.renting.main.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.config
 * @Author: 吴第广
 * @CreateTime: 2023-04-24  09:26
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件（官网最新）
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}