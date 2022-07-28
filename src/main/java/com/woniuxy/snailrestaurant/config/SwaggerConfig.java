package com.woniuxy.snailrestaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy(value = false)
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                //配置Swagger信息
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(tokenScheme()))
                .securityContexts(Arrays.asList(tokenContext()))
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.woniuxy.snailrestaurant.controller")).build();
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
                new Contact("yuan", "https://google.com", "dev@google.com"),
                /*Contact(String name, String url, String email)*/
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }




    private HttpAuthenticationScheme tokenScheme() {
        return HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("Authorization").build();
    }

    private SecurityContext tokenContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(SecurityReference.builder()
                        .scopes(new AuthorizationScope[0])
                        .reference("Authorization")
                        .build()))
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();
    }
}
