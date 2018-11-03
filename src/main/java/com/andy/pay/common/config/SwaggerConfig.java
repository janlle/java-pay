package com.andy.pay.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author Leone
 * @since 2018-4-15
 **/
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket webApi() {
        Parameter parameter = new ParameterBuilder()
                .name("Authorization")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .defaultValue("token ")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("服务API接口文档")
                .apiInfo(apiInfo())
                .globalOperationParameters(Collections.singletonList(parameter))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andy.pay.web"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket aliApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付宝API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andy.pay.ali"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket weiXinApi() {
        Parameter parameter = new ParameterBuilder()
                .name("Authorization")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .defaultValue("token ")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("微信API接口文档")
                .globalOperationParameters(Collections.singletonList(parameter))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andy.pay.wx"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket unionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("银联API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andy.pay.unionpay"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("支付系统")
                .description("微信、支付宝、银联支付服务")
                .termsOfServiceUrl("https://lyon.com")
                .version("v1.0.1")
                .license("Apache2.0")
                .contact(new Contact("lyon", "https://lyon.com", "lyon@gmail.com"))
                .licenseUrl("http://www.apache.org")
                .build();
    }

}