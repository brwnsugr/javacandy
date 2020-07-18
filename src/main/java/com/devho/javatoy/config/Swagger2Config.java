package com.devho.javatoy.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;



import java.util.Collections;

@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devho.javatoy"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "for test API",
                "Some custom description of API.",
                "0.0.1",
                "Terms of service",
                new Contact("swdream", "https://swengineer7.tistory.com", "swdream.a@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

}
