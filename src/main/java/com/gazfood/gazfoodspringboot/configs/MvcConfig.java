package com.gazfood.gazfoodspringboot.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${dishes.path}")
    private String dishesPath;

    @Value("${avatars.path}")
    private String avatarsPath;

    @Value("${cafeterias.path}")
    private String cafeteriasPath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadPath/**").addResourceLocations("file://" + uploadPath + "/")
                .addResourceLocations("/dishes/**").addResourceLocations("file://" + dishesPath + "/")
                .addResourceLocations("/avatars/**").addResourceLocations("file://" + avatarsPath + "/")
                .addResourceLocations("/cafeterias/**").addResourceLocations("file://" + cafeteriasPath + "/");
    }
}
