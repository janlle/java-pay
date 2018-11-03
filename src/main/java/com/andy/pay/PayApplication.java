package com.andy.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring-boot 支付demo
 * nohup java -jar --server.port=8886 spring-boot-pay.jar > web.log &
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.andy.pay.mapper")
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }

}