package com.wdg.renting.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.config
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  21:11
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class ConfigurationAdapter implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(false)
                .allowedMethods("POST","GET","DELETE","PUT","OPTIONS")
                .allowedOrigins("*")
        ;
    }
}