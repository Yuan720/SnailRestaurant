package com.woniuxy.snailrestaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("token")
                .allowCredentials(true)
                .maxAge(3600)
                .allowCredentials(true);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        /** swagger配置 */
//        registry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//    }
}
