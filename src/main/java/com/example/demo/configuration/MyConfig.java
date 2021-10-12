package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("WebMvcConfigurer - addResourceHandlers() function get loaded...");
        registry.addResourceHandler("/webres/**").addResourceLocations("file:///Users/huangzhi/IdeaProjects/webres/");
    }

}
