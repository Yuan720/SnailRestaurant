package com.woniuxy.snailrestaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());//配置Swagger信息
    }

    //配置Swagger信息
    /*String title, String description,
     String version, String termsOfServiceUrl,
     Contact contact, String license,
     String licenseUrl,
     Collection<VendorExtension> vendorExtensions*/
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "智慧餐厅",
                "智慧餐厅Swagger API文档",
                "V1.0",
                "https://google.com",
                new Contact("李小亮,孟汶", "https://google.com", "dev@google.com"),
                /*Contact(String name, String url, String email)*/
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
